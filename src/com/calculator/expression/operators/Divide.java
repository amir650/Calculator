package com.calculator.expression.operators;

final class Divide implements Expression {

    private final Expression leftOperand;
    private final Expression rightOperand;

    Divide(final Expression left,
           final Expression right) {
        this.leftOperand = left;
        this.rightOperand = right;
    }

    @Override
    public int interpret()  {
        final int numerator = this.rightOperand.interpret();
        final int denominator = this.leftOperand.interpret();
        if(denominator == 0) {
            throw new ArithmeticException("Divide by zero!");
        }
        return numerator / denominator;
    }

}