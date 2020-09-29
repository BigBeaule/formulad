package com.bigb.vassal.formuled.element.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * 
 */
@Getter
@RequiredArgsConstructor
public enum Font {
    SERIF("Serif"), //
    SANS_SERIF("SansSerif"), //
    MONOSPACED("Monospaced"), //
    DIALOG("Dialog"), //
    DIALOG_INPUT("DialogInput");

    @JsonValue
    private final String code;
    
    @Override
    public String toString() {
        return this.getCode();
    }
}
