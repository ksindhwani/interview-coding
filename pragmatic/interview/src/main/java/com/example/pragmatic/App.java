package com.example.pragmatic;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        int n = 4;
        List<String> output = new Question1().getPossibleCombinations(n);
        for(String combination : output) {
            System.out.println(combination);
        }

    }
}
