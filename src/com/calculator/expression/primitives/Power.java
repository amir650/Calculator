package com.calculator.expression.primitives;

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
        final int x = this.rightOperand.interpret();
        final int y = this.leftOperand.interpret();
        if(y < 0) {
            throw new UnsupportedOperationException("Not supported!");
        }
        return powerImpl(x, y);
    }

    private static int powerImpl(final int a,
                                 final int b) {
        return b == 0 ? 1 : a * powerImpl(a, b - 1);
    }

}