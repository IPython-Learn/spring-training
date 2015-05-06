package com.innominds.spring.el;

import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

public class SpELExample {

    public static void main(String[] args) {

        toUpperCase();
        getBytes();
        toUpperCase();

    }

    public static void concatString() {

        ExpressionParser parser = new SpelExpressionParser();
        Expression exp = parser.parseExpression("'Hello world '.concat('!')");
        String message = (String) exp.getValue();
        System.out.println(message);
    }

    public static void getBytes() {
        ExpressionParser parser = new SpelExpressionParser();
        Expression exp = parser.parseExpression("'ABCDEFG'.bytes");
        byte[] bytes = (byte[]) exp.getValue();
        for (int i = 0; i < bytes.length; i++) {
            System.out.print(bytes[i] + " ");
        }
    }

    public static void toUpperCase() {
        ExpressionParser parser = new SpelExpressionParser();

        Expression exp = parser.parseExpression("new String('hello world').toUpperCase()");
        String message = exp.getValue(String.class);
        System.out.println(message);
        // OR
        System.out.println(parser.parseExpression("'hello world'.toUpperCase()").getValue());

    }
}
