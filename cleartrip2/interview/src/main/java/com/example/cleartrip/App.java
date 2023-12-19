package com.example.cleartrip;

/**
 * Hello world!
 *
 * sujaritha.p@cleartrip.com
 * 
 * 
 * Hospital 
 * N number of rooms
 * 
 * patient P - startdate - enddate 
 * 
 * 
 * M number of patients at any time
 * 
 * 
 * N = 5
 * 
 * 5 patients 
 * 
 * Dec 4 - Dec 6
 * Dec 7 - Dec 8
 * 
 * Dec 4 - Dec 8 
 * Dec 4 - Dec 8 
 * 
 * Dec 4 - Dec 8
 * 
 * 
 * 4 - 7
 * 
 * dec 4 -dec 6  - 1  
 * dec4 - dec 6 - 1
 * dec 7 - dec 8 - 0
 * dec 7 - dec 8 - 0
 * dec4 - dec 8  - 1
 * 
 * dec 4 - dec 7 - 1 
 * 
 * dec 8 - dec 10  - 0 
 * 
 * 
 *  1. Sort the patents in ascending order of exit date
 *  2. Scan the m patients , keep a track of overlapping interval
 *  3. if any interval lies in that overlapping interval, increment rooms required ( RR)
 *  4. if RR = N , i'll not accomdate pateints - keep counter of that 
 *  5. display RR, NAP
 * 
 * 
 * How many rooms are required 
 * 
 * How many patients are being turned down 
 * 
 * 
 * 
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }
}
