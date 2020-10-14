package com.bigb.vassal.formuled.element.enums;

import java.util.Arrays;
import java.util.Collection;
import java.util.EnumSet;
import java.util.List;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * 
 */
@Getter
@RequiredArgsConstructor
public enum CarResource {
    TIRE("Tires"), //
    BRAKE("Brake"), //
    FUEL("Fuel"), //
    ENGINE("Engine"), //
    BODY("Bodywork"), //
    HOLDING("Roadholding");

    private final String type;
    
    @Override
    public String toString() {
        return getType();
    }

    public static final Collection<CarResource> CAR_RESOURCE_V1 = EnumSet.allOf(CarResource.class);
    public static final List<CarResource> CAR_RESOURCE_V2 = Arrays.asList(FUEL, BRAKE, ENGINE, BODY, HOLDING, TIRE);
}
