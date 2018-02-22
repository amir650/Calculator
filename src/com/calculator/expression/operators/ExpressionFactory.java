package com.calculator.expression.operators;

import java.util.Stack;

public class ExpressionFactory {

    private static final String EXPRESSION_DELIMITER = " ";
    private static final String PLUS_TOKEN = "+";
    private static final String MINUS_TOKEN = "-";
    private static final String MULTIPLY_TOKEN = "*";
    private static final String DIVIDE_TOKEN = "/";
    private static final String POWER_TOKEN = "^";

    private ExpressionFactory(){
        throw new RuntimeException("Not instantiable!");
    }

    public static Expression createExpression(final String expressionText,
                                              final VariablesScope variables) {
        final Stack<Expression> expressionStack = new Stack<>();
        for (final String token : expressionText.split(EXPRESSION_DELIMITER)) {
            expressionStack.push(createSubExpression(token, expressionStack, variables));
        }
        return expressionStack.pop();
    }

    private static Expression createSubExpression(final String token,
                                                  final Stack<Expression> expressionStack,
                                                  final VariablesScope variables) {
        final Expression subExpression;
        switch (token) {
            case PLUS_TOKEN :
                subExpression = new Plus(expressionStack.pop(), expressionStack.pop());
                break;
            case MINUS_TOKEN :
                subExpression = new Minus(expressionStack.pop(), expressionStack.pop());
                break;
            case MULTIPLY_TOKEN :
                subExpression = new Multiply(expressionStack.pop(), expressionStack.pop());
                break;
            case DIVIDE_TOKEN :
                subExpression = new Divide(expressionStack.pop(), expressionStack.pop());
                break;
            case POWER_TOKEN:
                subExpression = new Power(expressionStack.pop(), expressionStack.pop());
                break;
            default:
                subExpression = createVariableExpression(token, variables);
                break;
        }
        return subExpression;
    }

    private static Expression createVariableExpression(final String token,
                                                       final VariablesScope variables) {
        if (token.matches("[a-z]")) {
            return new Variable(token, variables);
        }
        throw new IllegalArgumentException("Invalid variable name: " +token);
    }

}
