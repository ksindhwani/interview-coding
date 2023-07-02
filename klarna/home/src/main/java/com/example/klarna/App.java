package com.example.klarna;

import java.security.interfaces.RSAKey;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Hello world!
 *
 */
public class App 
{

    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }

    public static List<String> findRejectedTransactions(List<String> transactions, int creditLimit) {
        Map<String,Integer> userLimit = new HashMap<>();
        List<String> result = new ArrayList<>();
        for(String transactionString : transactions) {
            String[] transactionArray = transactionString.split(",");
            String firstName = transactionArray[0];
            String lastName = transactionArray[1];
            String email = transactionArray[2];
            String id = transactionArray[4];
            int amount = Integer.parseInt(transactionArray[3]);
            int userRemainingCreditLimit = creditLimit;
            String key = firstName+lastName+email;

            if(userLimit.containsKey(key)) {
                userRemainingCreditLimit = userLimit.get(key);
            } else {
                userRemainingCreditLimit = creditLimit;   
                userLimit.put(key, userRemainingCreditLimit);
            }
            if(amount > userRemainingCreditLimit) {
                result.add(id);
            } else {
                userLimit.put(key, userRemainingCreditLimit-amount);
            }
        }

        return result;
    }
}
