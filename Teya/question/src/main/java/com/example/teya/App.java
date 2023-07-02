package com.example.teya;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       String input = "GBP:1000|   :GBP:100,354:GBP:300";
       System.out.println(Result.GeneratePaymentBatches(input));
    }
}
