package com.bigb.vassal.formuled.element.prototype;

import com.bigb.vassal.formuled.element.enums.Prototype;
import com.bigb.vassal.formuled.element.trait.PrototypeRef;
import com.bigb.vassal.formuled.element.trait.Traits;
import com.bigb.vassal.formuled.element.trait.Layer.LayerBuilder;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * 
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
class CarIdentifierPrototype {
    static PrototypeDefinition buildPrototype(Prototype prototype, int carId) {
        Traits traits = new Traits();
        traits.addTrait(new PrototypeRef(Prototype.CAR));
        traits.addTrait(new LayerBuilder("# Number").addLevel("N_Racer_" + carId + ".png").build(1));
        return new PrototypeDefinition(prototype, traits);
    }
}
