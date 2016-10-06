package com.calculator.expression.primitives;

import com.calculator.expression.Expression;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class VariablesScope {

    private final Map<String, Expression> variables;

    private VariablesScope(final Builder builder) {
        this.variables = Collections.unmodifiableMap(builder.variables);
    }

    public Expression lookup(final String key) {
        return this.variables.get(key);
    }

    public static class Builder {

        private final Map<String, Expression> variables;

        public Builder() {
            this.variables = new HashMap<>();
        }

        public Builder setVar(final String variable,
                              final int value) {
            this.variables.put(variable, new Number(value));
            return this;
        }

        public VariablesScope build() {
            return new VariablesScope(this);
        }

    }

}
