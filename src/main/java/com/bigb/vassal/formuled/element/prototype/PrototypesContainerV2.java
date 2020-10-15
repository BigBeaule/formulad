package com.bigb.vassal.formuled.element.prototype;

import com.bigb.vassal.formuled.element.CustomHotKey;
import com.bigb.vassal.formuled.element.enums.CarResource;
import com.bigb.vassal.formuled.element.enums.Prototype;

public class PrototypesContainerV2 extends PrototypesContainer {

    public PrototypesContainerV2() {
        super(Prototype.PROTOTYPE_V2.size());

        for (Prototype prototype : Prototype.PROTOTYPE_V2) {
            switch (prototype) {
            case CAR:
                addPrototype(CarPrototype.buildPrototype());
                break;
            case CAR_1:
                addPrototype(CarIdentifierPrototype.buildPrototype(prototype, 1));
                break;
            case CAR_2:
                addPrototype(CarIdentifierPrototype.buildPrototype(prototype, 2));
                break;
            case MARKER:
                addPrototype(MarkerPrototype.buildPrototype());
                break;
            case DASH_BOX:
                addPrototype(DashBoxPrototype.buildPrototypeV2());
                break;
            case DASH_GEARS:
                addPrototype(DashGearPrototype.buildPrototypeV2());
                break;
            case SETUP_BOX:
                addPrototype(SetupBoxPrototype.buildPrototype(prototype, 6));
                break;
            case SETUP_BOX_TIRES:
                addPrototype(SetupBoxPrototype.buildPrototype(prototype, 12));
                break;
            case CLEAR_TIRES:
                addPrototype(ClearTiresPrototype.buildPrototype());
                break;
            case CHECK_ENGINE:
                addPrototype(ResourceTestPrototype.buildPrototype(prototype, CarResource.ENGINE, 4, 3,
                        CustomHotKey.ROLL_ENGINE, CustomHotKey.LOSE_ENGINE, getNextId()));
                break;
            case CHECK_COLLISION:
                addPrototype(ResourceTestPrototype.buildPrototype(prototype, CarResource.BODY, 1, 2,
                        CustomHotKey.ROLL_COLLISION, CustomHotKey.LOSE_COLLISION, getNextId()));
                break;
            case CHECK_HAZARD:
                addPrototype(ResourceTestPrototype.buildPrototype(prototype, CarResource.HOLDING, 4, 5,
                        CustomHotKey.ROLL_HAZARD, CustomHotKey.LOSE_HAZARD, -1));
                break;
            default:
                throw new IllegalArgumentException("Undefined prototype " + prototype.getId());
            }
        }
    }
}
