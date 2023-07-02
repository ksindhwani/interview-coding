package com.example.talabat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductSearch {

     public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products); // Sort the products array in lexicographical order
        List<List<String>> result = new ArrayList<>();
        String prefix = "";
        
        for (char c : searchWord.toCharArray()) {
            prefix += c; // Add the current character to the prefix
            int startIndex = binarySearch(products, prefix); // Find the starting index of the products with the common prefix
            
            if(startIndex != -1) {
                List<String> suggestions = new ArrayList<>();
            for (int i = startIndex; i < Math.min(startIndex + 3, products.length); i++) {
                if (products[i].startsWith(prefix)) {
                    suggestions.add(products[i]); // Add products with the common prefix to the suggestions list
                }
            }
            
            result.add(suggestions); // Add the suggestions for the current prefix to the result list
            } 
        }
        
        return result;
    }
    
    private int binarySearch(String[] products, String prefix) {
        int left = 0;
        int right = products.length - 1;
        int midIndex = -1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (products[mid].startsWith(prefix)) {
                midIndex = mid;
                right = mid - 1;
            } else if (products[mid].compareTo(prefix) < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return midIndex;
    }
}