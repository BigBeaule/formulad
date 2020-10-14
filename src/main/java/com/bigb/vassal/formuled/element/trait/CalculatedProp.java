package com.bigb.vassal.formuled.element.trait;

import com.bigb.vassal.formuled.element.Expression;

import lombok.NonNull;

public class CalculatedProp extends AbstractTrait {
    public CalculatedProp(@NonNull String name, Expression expression) {
        super("calcProp", name, expression);
    }
}
