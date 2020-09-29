package com.bigb.vassal.formuled.element.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * 
 */
@Getter
@RequiredArgsConstructor
public enum Position {
    BOTTOM("b"), //
    CENTER("c"), //
    LEFT("l"), //
    RIGHT("r"), //
    TOP("t"); //
    
    private final String value;
    
    @Override
    public String toString() {
        return getValue();
    }
}
