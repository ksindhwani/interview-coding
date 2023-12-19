package com.example.asus.interview;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Given Numbers N and M, 
 * Find M numbers such that their sum is N and each numbers is in the range 1-6
 * 
 */
public class Question1 {

    public List<List<Integer>> solve (int n, int m) {
        List<Integer> currentList = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        solveHelper(n,m,currentList, result);
        return result;
    }

    private boolean solveHelper(int n, int m, List<Integer> currentList, List<List<Integer>> result) {
        System.out.printf("N = %d , M = %d", n , m);
        System.out.print("  List = " + currentList + "\n");
        if(n == 0 && m == 0) {
            result.add(new ArrayList<>(currentList));
            return true;
        }

        if(n < 0 || m < 0) {
            return false;
        }

        if(m == 0 && n!= 0) {
            return false;
        }

        for(int i = 1; i<=6 ; i++) {
            currentList.add(i);
            solveHelper(n-i, m-1, currentList, result);
            currentList.remove(currentList.size()-1);
        }

        return false;
    }
}
