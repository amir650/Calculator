package com.calculator.expression.evaluation;

import com.calculator.expression.operators.Expression;
import com.calculator.expression.operators.ExpressionFactory;
import com.calculator.expression.operators.VariablesScope;

public final class Evaluator {

    private final Expression syntaxTree;

    public Evaluator(final String expressionText) {
        this.syntaxTree = buildSyntaxTree(expressionText, null);
    }

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