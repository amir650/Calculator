package com.calculator.expression.primitives;

import com.calculator.expression.Expression;

final class Plus implements Expression {

    private final Expression leftOperand;
    private final Expression rightOperand;

    Plus(final Expression left,
         final Expression right) {
        this.leftOperand = left;
        this.rightOperand = right;
    }

    @Override
    public int interpret()  {
        return this.leftOperand.interpret() + this.rightOperand.interpret();
    }
}
