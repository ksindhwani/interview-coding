package com.example.okx.interview;

import java.util.Stack;

public class ExpressionCalculator {

    private final String delimiter = "#";

    public int calculateExpression(String expression) {
        String newExpression = buildExpressionWithDelimiter(expression);
        String[] tokens = getStringTokens(newExpression);
        return evaluateExpression(tokens);
    }

    private String buildExpressionWithDelimiter(String expression) {
        StringBuilder builder = new StringBuilder();
        for(Character character: expression.toCharArray()) {
            if(isOperator(character.toString())) {
                builder.append(delimiter);
                builder.append(character);
                builder.append(delimiter);
            } else {
                builder.append(character);
            }
        }
        return builder.toString();
    }

    private int evaluateExpression(String[] tokens) {
        Stack<Integer> operandStack = new Stack<>();
        Stack<String> operatorStack = new Stack<>();
        for(String token : tokens) {
            if(isOperator(token)) {
                if(operatorStack.isEmpty() || operandStack.size() == 1) {
                    operatorStack.push(token);
                } else {
                    while(!(operatorStack.isEmpty()) && isHighPrecedence(operatorStack.peek(), token)) {
                        int tempResult = performOperation(operatorStack.pop(), operandStack.pop(), operandStack.pop());
                        operandStack.push(tempResult);
                    }
                    operatorStack.push(token);
                }
            } else {
                operandStack.push(Integer.parseInt(token));
            }
        }

        int result = 0;
        while(!operatorStack.isEmpty()) {
            result = performOperation(operatorStack.pop(), operandStack.pop(), operandStack.pop());
            operandStack.push(result);
        }
        return result;
    }

    private boolean isHighPrecedence(String peek, String token) {
        return Operator.isDivide(peek)
        || Operator.isMultiply(peek) && (Operator.isMultiply(token) || Operator.isAdd(token) || Operator.isSubtract(token))
        || Operator.isAdd(peek) && (Operator.isAdd(token) || Operator.isSubtract(token));
    }

    private int performOperation(String operator, Integer number2, Integer number1) {
        if(Operator.isDivide(operator)) {
            return number1/number2;
        } else if(Operator.isMultiply(operator)) {
            return number1*number2;
        } else if(Operator.isAdd(operator)) {
            return number1+number2;
        } else {
            return number1-number2;
        }
    }

    private String[] getStringTokens(String expression) {
        return expression.split(delimiter);
    }

    public static boolean isOperator(String token) {
        return Operator.isDivide(token)
        || Operator.isMultiply(token)
        || Operator.isAdd(token)
        || Operator.isSubtract(token);
    }
}
