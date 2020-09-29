package com.bigb.vassal.formuled.element;

import lombok.RequiredArgsConstructor;

/**
 * 
 */
@RequiredArgsConstructor
public class Expression {
    private final String expression;

    private final boolean needWrap;

    public Expression(String expression) {
        this(expression, false);
    }

    @Override
    public String toString() {
        if (needWrap) {
            return '{' + expression + '}';
        }

        return expression;
    }
}
