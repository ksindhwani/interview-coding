package com.example.teya;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Result {

    public static String GeneratePaymentBatches(String fundsAndPayments) {
        Set<String> supportedCurrencies = getSupportedCurrenciesMap();
        String[] fundsAndPaymentsArray = fundsAndPayments.split("\\|");
        Map<String, Float> funds = getCurrencyFunds(fundsAndPaymentsArray[0]);
        Map<String, List<Payment>> paymentMap = preparePaymentMap(fundsAndPaymentsArray[1], supportedCurrencies);
        
        for(String currency : paymentMap.keySet()) {
            Collections.sort(paymentMap.get(currency));
        }

        String result = prepareBatches(funds, paymentMap, supportedCurrencies);

        return result;

    }

    private static Set<String> getSupportedCurrenciesMap() {
        Set<String> supportedCurrencies = new TreeSet<>();
        supportedCurrencies.add("CZK");
        supportedCurrencies.add("EUR");
        supportedCurrencies.add("GBP");
        return supportedCurrencies;
    }

    private static Map<String, List<Payment>> preparePaymentMap(String paymentString, Set<String> supportedCurrencies) {
        Map<String, List<Payment>> paymentMap = new HashMap<>();
        List<Payment> payments = null;
        String[] merchantPaymentArray = paymentString.split("\\,");
        for(String merchantPaymentString : merchantPaymentArray) {
            String[] paymentArray = merchantPaymentString.split("\\:");
            String currency =  paymentArray[1];
            if(supportedCurrencies.contains(currency)) {
                Payment payment = preparePayment(paymentArray);
                if(payment != null) {
                    if(paymentMap.containsKey(currency)) {
                        payments = paymentMap.get(currency);
                    } else {
                        payments = new ArrayList<>();
                    }
                    payments.add(payment);
                    paymentMap.put(currency, payments);
                }
            }
        }
        return paymentMap;
    }


    private static Payment preparePayment(String[] paymentArray) {
        Payment payment = null;
        try {
            int merchantId = Integer.parseInt(paymentArray[0]);
            String currency =  paymentArray[1];
            Float amount = Float.parseFloat(paymentArray[2]);
            payment = new Payment(merchantId, currency, amount);
        } catch (Exception ex) {
            // Log Exception for invalid input.
        }
        return payment; 
    }

    private static Map<String, Float> getCurrencyFunds(String fundString) {
        Map<String, Float> fundMap = new HashMap<>();
        String[] funds = fundString.split("\\,");
        
        for(String fund : funds) {
            String[] fundAndCurrency = fund.split("\\:");
            try {
                fundMap.put(fundAndCurrency[0], Float.parseFloat(fundAndCurrency[1]));
            } catch(Exception ex) {
                 // Log Exception for invalid input.
            }
        }
        return fundMap;
    }

    private static String prepareBatches(Map<String, Float> funds, Map<String, List<Payment>> paymentMap, Set<String> currencies) {
        StringBuilder result = new StringBuilder();
        boolean isCurrencyIncluded = false;
        for(String currency : currencies) {
            if(funds.containsKey(currency)) {
                isCurrencyIncluded =  true;
                List<Payment> payments = paymentMap.get(currency);
                if(payments != null && payments.size() > 0) {
                    for(Payment payment : payments) {
                        if(payment.getActualAmount() < funds.get(currency)) {
                            funds.put(currency, funds.get(currency) - payment.getActualAmount());
                            if(isCurrencyIncluded) {
                                result.append(currency);
                                result.append("\n");
                                isCurrencyIncluded = false;
                            }
                            result.append(payment.toString());
                            result.append("\n");
                        }
                    }
                }
            }
        }
        return result.toString().trim();
    }
}
