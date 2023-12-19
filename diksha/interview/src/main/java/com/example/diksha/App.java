package com.example.diksha;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws ParseException
    {
        /* 1
        
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy G");
        Date parse = sdf.parse("30/01/-2020 AD");
        System.out.println(sdf.format(parse));
        
        */

        /*int []a = new int[10];
        byte[] b = new byte[10];

        char[] c = new char[10];

        double[] d = new double[10];

        System.out.println(a[0] + " " + b[0] + " " + c[0] + " "  + d[0] );*/

        /*int a = 260;
        byte b = (byte)a;
        System.out.println(b);*/


        int n = 3;
        int m = 3;

        int[][] mat =  new int[n][m];
        int [] arr = new int[] { 5,4,8,7,6,1,9,2,3};

        mat[0][0] = 3;
        mat[0][1] = 1;
        mat[0][2] = 8;
        mat[1][0] = 4;
        mat[1][1] = 6;
        mat[1][2] = 2;
        mat[2][0] = 7;
        mat[2][1] = 5;
        mat[2][2] = 9;

        System.out.println(new Bingo().getBingoNumber(mat, arr));
    }


}
