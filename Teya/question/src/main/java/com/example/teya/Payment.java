package com.example.teya;

import java.util.HashMap;
import java.util.Map;

public class Payment implements Comparable<Payment>{
    private int merchantId;
    private String currency;
    private float amount;
    private float actualAmount;

    private Map<String,Float> processingFeeMap = prepareProcessingFeeMap();

    public Payment() {}
    public Payment(int merchantId, String currency, float amount) {
        this.merchantId = merchantId;
        this.currency = currency;
        this.amount = amount;
        this.actualAmount = calculateActualAmount();
    }

    public int getMerchantId() {
        return merchantId;
    }
    public String getCurrency() {
        return currency;
    }
    public float getAmount() {
        return amount;
    }
    public float getActualAmount() {
        return actualAmount;
    }



    @Override
    public String toString() {
        return merchantId + ":" + currency + ":" + String.format("%.2f", actualAmount);
    }

    @Override
    public int compareTo(Payment o) {
        return Float.compare(this.actualAmount, o.actualAmount);
    }

    private Map<String, Float> prepareProcessingFeeMap() {
        Map<String, Float> processingFeeMap = new HashMap<>();
        processingFeeMap.put("CZK", (float)0.005);
        processingFeeMap.put("EUR", (float)0.005);
        processingFeeMap.put("GBP", (float)0.0033);
        return processingFeeMap;
    }
    
    private float calculateActualAmount() {
        return roundOff(this.amount - processingFeeMap.get(this.currency) * this.amount);
    }

    private float roundOff(float number) {
       float roundedNumber = (float) Math.ceil(number * 100) / 100;
       return roundedNumber;
    }
}
