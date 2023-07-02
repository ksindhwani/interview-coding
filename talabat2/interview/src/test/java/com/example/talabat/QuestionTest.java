package com.example.talabat;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class QuestionTest {

    @Test
    public void testMultiplication() {
        int number1 = 5;
        int number2 = 4;

        Calculator calculator = getNewCalculator();
        int result = calculator.multiplyWithoutSign(number1,number2);
        assertEquals(20, result);

    }

    @Test
    public void testMultiplicationWith0() {
        int number1 = 5;
        int number2 = 0;
        
        Calculator calculator = getNewCalculator();
        int result = calculator.multiplyWithoutSign(number1,number2);
        assertEquals(0, result);
    }

    @Test
    public void testMultiplicationWithNegativeNumber() {
        int number1 = 5;
        int number2 = -4;

        Calculator calculator =  getNewCalculator();
        int result = calculator.multiplyWithoutSign(number1,number2);
        assertEquals(-20, result);
    }

    @Test
    public void testMultiplicationWithFirstNumberAsNegative() {
        int number1 = -5;
        int number2 = 4;

        Calculator calculator =  getNewCalculator();
        int result = calculator.multiplyWithoutSign(number1,number2);
        assertEquals(-20, result);
    }

    @Test
    public void testMultiplicationWithBothNumbersAsNegative() {
        int number1 = -5;
        int number2 = -4;

        Calculator calculator =  getNewCalculator();
        int result = calculator.multiplyWithoutSign(number1,number2);
        assertEquals(20, result);
    }

    public Calculator getNewCalculator() {
        return new Calculator();
    }
}
