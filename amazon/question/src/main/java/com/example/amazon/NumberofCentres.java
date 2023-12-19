package com.example.amazon;

import java.util.List;

public class NumberofCentres {

    public int suitableLocations(List<Integer> center, long d) {
        int n = center.size();

        int result = 0;

        int centreMinValue = Integer.MAX_VALUE;
        int centreMaxValue = Integer.MIN_VALUE;

        for(int i = 0;i<n;i++) {
            centreMinValue = Math.min(centreMinValue, center.get(i));
            centreMaxValue = Math.max(centreMaxValue, center.get(i));
        }


        int possibleXMinValue = centreMinValue - (((int)d - Math.abs(centreMaxValue- centreMinValue))/2);
        int possibleXMaxValue = centreMaxValue + (((int)d - Math.abs(centreMaxValue- centreMinValue))/2);
        

        for(int i = possibleXMinValue;i<=possibleXMaxValue; i++) {
            long totalDistance = 0;
            for(int j = 0;j<n;j++) {
                totalDistance= totalDistance + 2*Math.abs(i-center.get(j));
            }
            if(totalDistance <= d) {
                result ++;
            }
        }

        return result;
    }
    
}
