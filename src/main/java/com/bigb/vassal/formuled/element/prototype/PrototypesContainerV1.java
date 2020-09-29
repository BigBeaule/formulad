package com.bigb.vassal.formuled.element.prototype;

import com.bigb.vassal.formuled.element.enums.Prototype;

public class PrototypesContainerV1 extends PrototypesContainer {

    public PrototypesContainerV1() {
        super(Prototype.PROTOTYPE_V1.size());

        for (Prototype prototype : Prototype.PROTOTYPE_V1) {
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
                    addPrototype(DashBoxPrototype.buildPrototypeV1());
                    break;
                case DASH_GEARS:
                    addPrototype(DashGearPrototype.buildPrototypeV1());
                    break;
                case SETUP_BOX:
                    addPrototype(SetupBoxPrototype.buildPrototype(prototype, 9));
                    break;
                default:
                    throw new IllegalArgumentException("Undefined prototype " + prototype.getId());
            }
        }
    }
}
