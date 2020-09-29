package com.bigb.vassal.formuled.element.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * 
 */
@Getter
@RequiredArgsConstructor
public enum DynPropTriggerType {
    INCREMENT("I"), //
    SET_VALUE("P"), //
    PROMPT("R"), //
    SELECT("E");
    
    private final String value;
}
