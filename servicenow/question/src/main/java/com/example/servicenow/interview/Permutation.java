package com.example.servicenow.interview;

class Permutation {

    public void generatePermuation(int n) 
    {
        char[] strNumber  = Integer.toString(n).toCharArray();
        generatePermutationHelper(strNumber, 0, strNumber.length-1);
    }
    
    private void generatePermutationHelper(char[] number, int start, int end) {
        if(number.length == 1 || start == end) {
            System.out.println(number);
        } else {
            for(int i = start;i<=end;i++) {
                swap(number, start,i);
                generatePermutationHelper(number,start+1,end);
                swap(number, start,i);
            }
        }
        
    }

    private void swap(char[] number , int source, int target) 
    {
        char temp = number[source];
        number[source] = number[target];
        number[target] = temp;
        
    }
}
