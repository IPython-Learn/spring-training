package com.innominds.spring.el;

import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

/**
 * SpELExample.java
 *
 * @author ThirupathiReddy V
 *
 */
public class SpELExample {

    /**
     * @param args
     */
    public static void main(String[] args) {
        SpELExample.logicalOperation();
        SpELExample.toUpperCase();
        SpELExample.getBytes();
        SpELExample.toUpperCase();

    }

    /**
     * logical operations
     */
    public static void logicalOperation() {

        final ExpressionParser parser = new SpelExpressionParser();
        final Expression exp = parser.parseExpression("6*30+5-1");
        final Integer message = exp.getValue(Integer.class);
        System.out.println(message);
    }

    /**
     * concatenating using SpEL
     */
    public static void concatString() {

        final ExpressionParser parser = new SpelExpressionParser();
        final Expression exp = parser.parseExpression("'Hello world '.concat('!')");
        final String message = (String) exp.getValue();
        System.out.println(message);
    }

    /**
     * converting String into bytes inside the SpEL
     */
    public static void getBytes() {
        final ExpressionParser parser = new SpelExpressionParser();
        final Expression exp = parser.parseExpression("'ABCDEFG'.bytes");
        final byte[] bytes = (byte[]) exp.getValue();
        for (final byte b : bytes) {
            System.out.print(b + " ");
        }
    }

    /**
     * invoking spring toUpperCase method inside the SpEL
     */
    public static void toUpperCase() {
        final ExpressionParser parser = new SpelExpressionParser();

        final Expression exp = parser.parseExpression("new String('hello world').toUpperCase()");
        final String message = exp.getValue(String.class);
        System.out.println(message);
        // OR
        System.out.println(parser.parseExpression("'hello world'.toUpperCase()").getValue());

    }
}
