package com.example.diksha;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Location {
    int rowNumber;
    int columnNumber;

    public Location(int rowNumber, int columnNumber) {
        this.rowNumber = rowNumber;
        this.columnNumber = columnNumber;
    }

    public int getRowNumber() {
        return rowNumber;
    }

    public int getColumnNumber() {
        return columnNumber;
    }
}

public class Bingo {

    public int getBingoNumber(int[][] mat, int[] arr) {
        Map<Integer, Location> locationMap = new HashMap<>();
        
        int n = mat.length;
        int m = mat[0].length;

        int[] rowCounter = new int[n];
        Arrays.fill(rowCounter, 0);

        int[] columnCounter = new int[m];
        Arrays.fill(columnCounter, 0);

        // Building Location map
        for(int i =0;i<n;i++) {
            for(int j =0;j<m;j++) {
                locationMap.put(mat[i][j], new Location(i, j));
            }
        }

        for(int i = 0;i<arr.length;i++) {
            Location location = locationMap.get(arr[i]);

            if(anyRowColumnFilled(n,m,location, rowCounter, columnCounter)) {
                return arr[i];
            }
        }
        return 0;
    }

    private boolean anyRowColumnFilled(int nRows, int mColumns, Location location, int[] rowCounter, int[] columnCounter) {
        
        // fill ith row
        rowCounter[location.getRowNumber()]++;

        // fill jth column
        columnCounter[location.getColumnNumber()]++;

        // check if row is filled

        if(rowCounter[location.getRowNumber()] == mColumns) {
            return true;
        } 

        if(columnCounter[location.getColumnNumber()] == nRows) {
            return true;
        }

        return false;
    }

    
}
