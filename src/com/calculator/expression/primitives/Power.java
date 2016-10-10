package com.calculator.expression.primitives;

import com.calculator.expression.Expression;

final class Power implements Expression {

    private final Expression leftOperand;
    private final Expression rightOperand;

    Power(final Expression left,
          final Expression right) {
        this.leftOperand = left;
        this.rightOperand = right;
    }

    @Override
    public int interpret()  {
        return power(this.rightOperand.interpret(), this.leftOperand.interpret());
    }

    private static int power(int a, int b) {
        int result = 1;
        for(int i = 0; i < b ;i++) {
            result *=a;
        }
        return result;
    }
}