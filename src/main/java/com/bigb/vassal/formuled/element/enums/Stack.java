package com.bigb.vassal.formuled.element.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Stack {
    TOP(0), //
    BOTTOM(1), //
    ABOVE(2), //
    BELOW(3); //

    private final int value;
}
