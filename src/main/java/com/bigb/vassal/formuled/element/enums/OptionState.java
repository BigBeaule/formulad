package com.bigb.vassal.formuled.element.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * 
 */
@Getter
@RequiredArgsConstructor
public enum OptionState {
    ALWAYS("Always"), //
    NEVER("Never");

    @JsonValue
    private final String value;
}
