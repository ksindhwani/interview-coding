package com.example.amazon;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        /*NumberofCentres nC = new NumberofCentres();

        List<Integer> center = new ArrayList<>();

        center.add(2);
        center.add(0);
        center.add(3);
        center.add(-4);


        long d = 22;

        System.out.println("Output = " + nC.suitableLocations(center, d));*/

        List<Integer> arr = new ArrayList<>();

        arr.add(2);
        arr.add(5);
        arr.add(4);
        arr.add(6);
        arr.add(8);


        System.out.println(new MaxOfMinima().segment(3, arr));
    }
}
