package com.example.talabat;

public class Calculator {

    public int multiplyWithoutSign(int number1, int number2) {
        int product = 0;
        Input input = new Input(number1,number2);

        for(int i=1;i<=input.getA();i++) {
            product+=input.getB();
        }
        return product;
    }
}
