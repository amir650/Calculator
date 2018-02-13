package com.calculator.expression.primitives;

final class Number implements Expression {

    private final int number;

    private Number(final int number) {
        this.number = number;
    }

    @Override
    public int interpret()  {
        return this.number;
    }

    static Number valueOf(final int number) {
        return new Number(number);
    }

}
