package com.bigb.vassal.formuled.element.trait;

import lombok.NonNull;

public class MenuSeparator extends AbstractTrait {
    public MenuSeparator(@NonNull String description) {
        super("menuSeparator", description, null);
    }
}
