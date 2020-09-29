package com.bigb.vassal.formuled.element.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * 
 */
@Getter
@RequiredArgsConstructor
public enum GamePiece {
    CAR("Car", 1),

    MARKER("Marker", 0);

    @JsonValue
    private final String name;

    private final int zIndex;
}
