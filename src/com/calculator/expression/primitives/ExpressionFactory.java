package com.calculator.expression.primitives;

import com.calculator.expression.Expression;
import java.util.Stack;

public class ExpressionFactory {

    private static final String EXPRESSION_DELIMITER = " ";

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
            case "+" :
                subExpression = new Plus(expressionStack.pop(), expressionStack.pop());
                break;
            case "-" :
                subExpression = new Minus(expressionStack.pop(), expressionStack.pop());
                break;
            case "*" :
                subExpression = new Multiply(expressionStack.pop(), expressionStack.pop());
                break;
            case "/" :
                subExpression = new Divide(expressionStack.pop(), expressionStack.pop());
                break;
            case "^":
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
        throw new RuntimeException("Invalid variable name: " +token);
    }

}
