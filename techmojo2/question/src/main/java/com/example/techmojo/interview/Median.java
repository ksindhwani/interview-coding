package com.example.techmojo.interview;

public class Median {

    public float GetMedian(int[] array) {
        double median;
        int[] countArray = new int[100];
        int n = array.length;

        for(int i = 0;i<n;i++) {
            countArray[i-1]++;
        }

        if(array.length % 2 != 0) {
            median = getNthTerm(countArray, (n+1)/2);
            return median/1.0;
        } else {
            int nthTerm =  getNthTerm(countArray, (n/2));
            int n1ThTerm = getNthTerm(countArray, (n/2) + 1);
            return (nthTerm + n1ThTerm)/2.0;

        }

    }
}
