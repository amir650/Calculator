package com.tests.calculator.expression;

import com.calculator.expression.evaluation.Evaluator;
import com.calculator.expression.operators.VariablesScope;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class Tests {

    @Test
    public void test1() {
        final VariablesScope variables =
                new VariablesScope.Builder()
                        .setVar("x", 3)
                        .setVar("y", 2)
                        .setVar("z", 11)
                        .build();
        final String expressionText = "x y * z -";
        final Evaluator evaluator = new Evaluator(expressionText, variables);
        final int result = evaluator.evaluate();
        assertEquals(-5, result);
    }

    @Test
    public void test2() {
        final VariablesScope variables =
                new VariablesScope.Builder()
                        .setVar("a", 2)
                        .setVar("b", 1)
                        .setVar("c", 12)
                        .setVar("d", 3)
                        .build();
        final String expressionText = "a b c d / - +";
        final Evaluator evaluator = new Evaluator(expressionText, variables);
        final int result = evaluator.evaluate();
        assertEquals(-1, result);
    }

    @Test
    public void test3() {
        final VariablesScope variables =
                new VariablesScope.Builder()
                        .setVar("a", 6)
                        .setVar("b", 3)
                        .setVar("c", 2)
                        .setVar("d", 11)
                        .build();
        final String expressionText = "a b - c ^ d -";
        final Evaluator evaluator = new Evaluator(expressionText, variables);
        final int result = evaluator.evaluate();
        assertEquals(-2, result);
    }

}
