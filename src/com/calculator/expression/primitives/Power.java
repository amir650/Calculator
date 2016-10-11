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
        return powerImpl(this.rightOperand.interpret(), this.leftOperand.interpret());
    }

    private static int powerImpl(final int a,
                                 final int b) {
        return b == 1 ? a : a * powerImpl(a, b - 1);
    }
}