package com.calculator.expression.operators;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class VariablesScope {

    private final Map<String, Expression> variables;

    private VariablesScope(final Builder builder) {
        this.variables = Collections.unmodifiableMap(builder.variables);
    }

    Expression lookup(final String name) {
        final Expression expression = this.variables.get(name);
        if(expression != null) {
            return this.variables.get(name);
        }
        throw new IllegalArgumentException("No expression associated with variable " +name+ "!");
    }

    public static class Builder {

        private final Map<String, Expression> variables;

        public Builder() {
            this.variables = new HashMap<>();
        }

        public Builder setVar(final String variable,
                              final int value) {
            this.variables.put(variable, Number.valueOf(value));
            return this;
        }

        public VariablesScope build() {
            return new VariablesScope(this);
        }

    }

}
