package com.example.pragmatic;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 
 * n =  number
 * 
 * Input =  (), ()
 * 
 * Output - number of combination possible 
 * 
 *  
 *  ["(())" , "()()"]
 * 
 * n = 3
 * 
 * [ ((())) , ()()(), (())(), ()(()) , (()()) ]
 * 
 * n = 3 
 * 
 * _ _ _ _ _ _
 * 
 * Left one has to keep open
 * right one has to keep close
 */
public class Question1 {

    public List<String> getPossibleCombinations(int n) {
        List<String> output = new ArrayList<>();

        StringBuilder builder = new StringBuilder(2 * n);
        builder.setLength(2*n);

        getPossibleCombinationsHelper(output, builder, 2*n, 0);

       return output;
    }

    private void getPossibleCombinationsHelper(List<String> output, StringBuilder builder, int length, int start) {

        if(start == length) {
            if(isValid(builder)) {
                output.add(new String(builder));
            }
            return; 
        }

        builder.setCharAt(start,'(');
        getPossibleCombinationsHelper(output, builder, length, start+1);
        builder.setCharAt(start, ')');
        getPossibleCombinationsHelper(output, builder, length, start+1);
    }

    private boolean isValid(StringBuilder builder) {
        if (builder.charAt(0) == ')') {
            return false;
        }

        Stack<Character> stack = new Stack<>();
        for(char character : builder.toString().toCharArray()) {
            if(character == '(') {
                stack.push(character);
            } else {
                if(!stack.isEmpty()) {
                     stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();

    }
}
