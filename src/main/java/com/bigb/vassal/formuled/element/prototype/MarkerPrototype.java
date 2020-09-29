package com.bigb.vassal.formuled.element.prototype;

import com.bigb.vassal.formuled.element.HotKey;
import com.bigb.vassal.formuled.element.enums.NoStackType;
import com.bigb.vassal.formuled.element.enums.Prototype;
import com.bigb.vassal.formuled.element.enums.Variable;
import com.bigb.vassal.formuled.element.trait.Clone;
import com.bigb.vassal.formuled.element.trait.Delete;
import com.bigb.vassal.formuled.element.trait.Marker;
import com.bigb.vassal.formuled.element.trait.NoStack;
import com.bigb.vassal.formuled.element.trait.Rotate;
import com.bigb.vassal.formuled.element.trait.Traits;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * 
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
class MarkerPrototype {
    static PrototypeDefinition buildPrototype() {
        Traits traits = new Traits();
        traits.addTrait(new Marker(Variable.LAYER.getVarName(), Prototype.MARKER.getId()));
        traits.addTrait(new Rotate(null, HotKey.CTRL_R, "Rotate"));
        traits.addTrait(new Clone());
        traits.addTrait(new Delete());
        traits.addTrait(new NoStack(NoStackType.NORMALLY));
        return new PrototypeDefinition(Prototype.MARKER, traits);
    }
}
