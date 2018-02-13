package com.calculator.expression.evaluation;

import com.calculator.expression.primitives.Expression;
import com.calculator.expression.primitives.ExpressionFactory;
import com.calculator.expression.primitives.VariablesScope;

public final class Evaluator {

    private final Expression syntaxTree;

    public Evaluator(final String expressionText,
                     final VariablesScope variables) {
        this.syntaxTree = buildSyntaxTree(expressionText, variables);
    }

    public int evaluate() {
        return this.syntaxTree.interpret();
    }

    private static Expression buildSyntaxTree(final String expressionText,
                                              final VariablesScope variables) {
        return ExpressionFactory.createExpression(expressionText, variables);
    }
}