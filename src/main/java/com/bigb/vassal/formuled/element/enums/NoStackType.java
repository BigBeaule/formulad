package com.bigb.vassal.formuled.element.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * 
 */
@Getter
@RequiredArgsConstructor
public enum NoStackType {
    // TODO This is solely based on value used in current game
    NORMALLY(";N"), //
    NEVER_NORMALLY_NEVER("n;V"), //
    NORMALLY_NORMALLY_NEVER(";V");

    private final String configuration;
}
