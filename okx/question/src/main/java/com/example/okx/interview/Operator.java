package com.example.okx.interview;

public class Operator {

    public static boolean isDivide(String operator) {
        return operator.contentEquals("/");
    }
    public static boolean isMultiply(String operator) {
        return operator.contentEquals("*");
    }
    public static boolean isAdd(String operator) {
        return operator.contentEquals("+");
    }
    public static boolean isSubtract(String operator) {
        return operator.contentEquals("-");
    }
}
