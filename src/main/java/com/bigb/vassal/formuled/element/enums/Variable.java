package com.bigb.vassal.formuled.element.enums;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

/**
 * 
 */
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum Variable implements ExpressionVariable {
    BOX("box"), //
    CAR("car"), //
    IS_CAR("isCar"), //
    STOPS("stops"), //
    GEAR("gear"), //
    SETUP("setup"), //
    
    INDEX("n"), //
    RESULT_1("result1"), //
    NUM_VALUE("numericalValue"), //

    NAME("name"), //
    PLAYER_ID("playerId"), //
    PLAYER("playerName"), //
    DRIVER("driverName"), //
    TEAM("teamName"), //

    LAYER("layer"), //
    LABEL("label"), //
    TURN("Turn"), // Capital T is normal
    DISABLED("disabled"), //

    MESSAGE("message"), //
    POSITION("position"), //
    
    WEATHER("weather"), //
    SUNNY("Sunshine"), //
    CLOUDY("Changeable"), //
    RAINY("Rain"), //
    
    D20("d20_result");
    
    private final String var;
    
    public String getVarName() {
        return var;
    }
    
    @Override
    public String toString() {
        return getVar();
    }
}