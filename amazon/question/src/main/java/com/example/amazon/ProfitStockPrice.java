package com.example.amazon;

public class ProfitStockPrice {
    int result = 0;

    public int findProfitableGroups(int[] stockPrice) {
        int n = stockPrice.length;

        for(int i = 0;i<n;i++) {
            int max = stockPrice[i];
            for(int j = i;j<n;j++) {
                if(stockPrice[j] > max ) {
                    max = stockPrice[j];
                }

                if(stockPrice[i] == max || stockPrice[j] == max) {
                    result++;
                }
            }
        }

        return result;
    }
    
}
