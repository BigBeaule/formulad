package com.bigb.vassal.formuled.element.trait;

import com.bigb.vassal.formuled.element.enums.NoStackType;

/**
 * 
 */
public class NoStack extends AbstractTrait {
    public NoStack(NoStackType type) {
        super("immob", type.getConfiguration());
    }
}
