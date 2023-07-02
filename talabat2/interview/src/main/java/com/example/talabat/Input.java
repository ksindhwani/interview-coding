package com.example.talabat;

public class Input {
    int a,b;
    public Input(int number1, int number2) {
        a = Math.abs(number1);
        b = Math.abs(number2);
        if(number1 < 0 && number2 > 0) {
            a = number2;
            b = number1;
        } else if (number1 > 0 && number2 < 0) {
             a = number1;
             b = number2;
        }
    }
    public int getA() {
        return a;
    }
    public int getB() {
        return b;
    }
}
