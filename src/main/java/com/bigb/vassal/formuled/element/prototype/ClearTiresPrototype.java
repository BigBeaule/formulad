package com.bigb.vassal.formuled.element.prototype;

import com.bigb.vassal.formuled.element.BaseElement;
import com.bigb.vassal.formuled.element.CustomHotKey;
import com.bigb.vassal.formuled.element.Expression;
import com.bigb.vassal.formuled.element.enums.CarResource;
import com.bigb.vassal.formuled.element.enums.Prototype;
import com.bigb.vassal.formuled.element.enums.SystemProperty;
import com.bigb.vassal.formuled.element.enums.Variable;
import com.bigb.vassal.formuled.element.trait.Button;
import com.bigb.vassal.formuled.element.trait.GlobalKey;
import com.bigb.vassal.formuled.element.trait.Report;
import com.bigb.vassal.formuled.element.trait.Traits;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ClearTiresPrototype {
    static PrototypeDefinition buildPrototype() {
        Traits traits = new Traits();
        traits.addTrait(new Button("Clear tires button", CustomHotKey.CLEAR_TIRES, 40, 40, -20, -20));
        traits.addTrait(new GlobalKey("Clear tires action", null, CustomHotKey.CLEAR_TIRES, CustomHotKey.INCREASE, //
                new Expression(SystemProperty.CURRENT_MAP.getVarName() + "==\"" + Variable.CAR + "\" && " //
                        + Variable.BOX.getVarName() + "==\"" + CarResource.TIRE + "\" && Box_Level==2", true),
                true));

        traits.addTrait(new Report("Report Clear Tires",
                BaseElement.PLAYER_CHAT + "clears used tires of " + Variable.CAR, CustomHotKey.CLEAR_TIRES));

        return new PrototypeDefinition(Prototype.CLEAR_TIRES, traits);
    }
}
