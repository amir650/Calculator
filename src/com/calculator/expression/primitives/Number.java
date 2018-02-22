package com.calculator.expression.primitives;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

final class Number implements Expression {

    private final int number;
    private static final List<Number> NUMBER_CACHE = init();

    private static List<Number> init() {
        final Number[] cache = new Number[1000];
        for(int i = 0; i < cache.length; i++) {
            cache[i] = new Number(i);
        }
        return Collections.unmodifiableList(Arrays.asList(cache));
    }

    private Number(final int number) {
        this.number = number;
    }

    @Override
    public int interpret()  {
        return this.number;
    }

    static Number valueOf(final int number) {
        if(number >= 0 && number < 1000) {
            return NUMBER_CACHE.get(number);
        }
        return new Number(number);
    }

}
