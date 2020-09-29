package com.bigb.vassal.formuled.element.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * 
 */
@Getter
@RequiredArgsConstructor
public enum Tire {
    HARD("Hard", 0, 0), //
    SOFT("Soft", 50, 48), //
    WET("Wet", 100, 96);

    private final String type;
    private final int offsetV1;
    private final int offsetV2;
}
