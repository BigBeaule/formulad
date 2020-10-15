package com.bigb.vassal.formuled.element.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import java.util.EnumSet;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * 
 */
@Getter
@RequiredArgsConstructor
public enum Prototype {
    CAR("Car"), //
    CAR_1("Car_1"), //
    CAR_2("Car_2"), //
    MARKER("Marker"), //
    DASH_BOX("DashBox"), //
    CLEAR_TIRES("ClearTires"), //
    DASH_GEARS("DashGears"), //
    SETUP_BOX("SetupBox"), //
    SETUP_BOX_TIRES("SetupBoxTires"), //
    CHECK_ENGINE("EngineCheck"), //
    CHECK_COLLISION("CollisionCheck"), //
    CHECK_HAZARD("HazardCheck");

    @JsonValue
    private final String id;

    @Override
    public String toString() {
        return this.getId();
    }

    public static final EnumSet<Prototype> PROTOTYPE_V1 = EnumSet.of(CAR, CAR_1, CAR_2, MARKER, DASH_BOX, DASH_GEARS,
            SETUP_BOX);

    public static final EnumSet<Prototype> PROTOTYPE_V2 = EnumSet.of(CAR, CAR_1, CAR_2, MARKER, DASH_BOX, DASH_GEARS,
            CLEAR_TIRES, SETUP_BOX, SETUP_BOX_TIRES, CHECK_ENGINE, CHECK_COLLISION, CHECK_HAZARD);
}
