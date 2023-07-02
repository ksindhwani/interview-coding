package com.example.epam.interview;

import java.util.HashMap;
import java.util.Map;

/**
 * Hello world!
 *
 */


public class App 
{
    public static void main( String[] args )
    {
        System.out.println( StringChallenge("onezeropluseight") );
    }

    public static String StringChallenge(String str) {
    Map<String,Integer> numberMap = createNumberMap();
    String expression = convertToExpression(str, numberMap);
    //int result = evaluateExpression(expression);
    //String finalresult = convertToWord(result);
    return expression;
  }

  public static Map<String,Integer> createNumberMap() {
     Map<String,Integer> numberMap = new HashMap<>();
     numberMap.put("zero", 0);
     numberMap.put("one", 1);
     numberMap.put("two", 2);
     numberMap.put("three", 3);
     numberMap.put("four", 4);
     numberMap.put("five", 5);
     numberMap.put("six", 6);
     numberMap.put("seven", 7);
     numberMap.put("eight", 8);
     numberMap.put("nine", 9);
     return numberMap;


  }
  public static String convertToExpression(String str, Map<String,Integer> numberMap) {
    StringBuilder builder = new StringBuilder();
    int i =0;
    String threeLetter = "";
    String fourLetter = "";
    String fiveLetter = "";
    while(i < str.length()) {
      //System.out.print("Enter loop = "); 
      if(str.charAt(i) == 'm') {
        builder.append("$");
        builder.append("-");
        builder.append("$");
        i+=5;
      }
      if(str.charAt(i) == 'p') {
        builder.append("$");
        builder.append("+");
        builder.append("$");
        i+=4;
      }

      if(i+3 <= str.length()) {
        threeLetter = str.substring(i,i+3);
      }
      if(i+4 <= str.length()) {
        fourLetter = str.substring(i,i+4);
      }
      if(i+5 <= str.length()) {
        fiveLetter = str.substring(i,i+5);
      }

      //System.out.print("threeLetter = " + threeLetter); 
      //System.out.print("fourletter = " + fourLetter); 
      //System.out.print("fiveLetter = " + fiveLetter); 
      if(numberMap.containsKey(threeLetter)) {
        builder.append(numberMap.get(threeLetter));
        i+=3;
      }
      if(numberMap.containsKey(fourLetter)) {
        builder.append(numberMap.get(fourLetter));
        i+=4;
      }
      if(numberMap.containsKey(fiveLetter)) {
        builder.append(numberMap.get(fiveLetter));
        i+=5;
      }
    }
    return builder.toString();
  }
}
