package com.bigb.vassal.formuled.element.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * 
 */
@Getter
@RequiredArgsConstructor
public enum Command {
    CLONE("Clone"), //
    DELETE("Delete"), //
    DISABLE("Disable"); // 

    @JsonValue
    private final String cmd;
    
    @Override
    public String toString() {
        return this.getCmd();
    }
}