package com.example.okx.interview;

/**
 * Write a Program to evaluate the String expression in java 
 * 5 = 3+5/2
 * 
 * Only +, -,/ and *
 * Digits will only be integers
 * input string is va;id 
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        String s = "3/2+4";
        int result = new ExpressionCalculator().calculateExpression(s);
        System.out.println(result);
    }
}
