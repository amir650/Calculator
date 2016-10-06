package com.calculator.expression.primitives;

import com.calculator.expression.Expression;

final class Number implements Expression {

    private final int number;

    Number(final int number) {
        this.number = number;
    }

    @Override
    public int interpret()  {
        return this.number;
    }
}
