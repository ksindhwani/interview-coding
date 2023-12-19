package com.example.servicenow.interview;

/**
 * Hello world!
 * 
 * 123 - n!
 * 
 * 123
 * 132
 * 213
 * 231
 * 312
 * 321
 * 
 * 
 * Single digit - return digit
 *
 * else {
 * 
 *  reverse each digit with first digot
 *  recurse for other digits
 *  reverse back to get the original number back
 * }
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        //System.out.println("Heelo Workd");
        new Permutation().generatePermuation(1234);
    }
}
