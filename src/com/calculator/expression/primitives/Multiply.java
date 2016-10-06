package com.calculator.expression.primitives;

import com.calculator.expression.Expression;

final class Multiply implements Expression {

    private final Expression leftOperand;
    private final Expression rightOperand;

    Multiply(final Expression left,
             final Expression right) {
        this.leftOperand = left;
        this.rightOperand = right;
    }

    @Override
    public int interpret()  {
        return this.leftOperand.interpret() * this.rightOperand.interpret();
    }
}