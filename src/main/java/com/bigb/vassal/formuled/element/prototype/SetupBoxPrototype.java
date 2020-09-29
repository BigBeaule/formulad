package com.bigb.vassal.formuled.element.prototype;

import com.bigb.vassal.formuled.configuration.Color;
import com.bigb.vassal.formuled.element.CustomHotKey;
import com.bigb.vassal.formuled.element.Expression;
import com.bigb.vassal.formuled.element.HotKey;
import com.bigb.vassal.formuled.element.enums.Command;
import com.bigb.vassal.formuled.element.enums.DynPropTriggerType;
import com.bigb.vassal.formuled.element.enums.Font;
import com.bigb.vassal.formuled.element.enums.NoStackType;
import com.bigb.vassal.formuled.element.enums.Position;
import com.bigb.vassal.formuled.element.enums.Prototype;
import com.bigb.vassal.formuled.element.enums.SystemProperty;
import com.bigb.vassal.formuled.element.enums.Variable;
import com.bigb.vassal.formuled.element.trait.DynamicProperty;
import com.bigb.vassal.formuled.element.trait.GlobalKey;
import com.bigb.vassal.formuled.element.trait.Label;
import com.bigb.vassal.formuled.element.trait.NoStack;
import com.bigb.vassal.formuled.element.trait.Report;
import com.bigb.vassal.formuled.element.trait.Restrict;
import com.bigb.vassal.formuled.element.trait.Traits;
import com.bigb.vassal.formuled.element.trait.DynamicProperty.DynamicPropertyTrigger;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * 
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
class SetupBoxPrototype {
    static PrototypeDefinition buildPrototype(Prototype prototype, int max) {
        Variable setup = Variable.SETUP;
        Expression setSetup = new Expression(SystemProperty.CURRENT_MAP.getVarName() + "=" + Variable.CAR + " && "
                + Variable.INDEX.getVarName() + "=" + setup + " && " + Variable.BOX.getVarName() + "=" + Variable.BOX);

        Traits traits = new Traits();
        traits.addTrait(
                new Restrict(Command.DISABLE, "Setup", new Expression(setup.getVarName() + "=" + 0), HotKey.CTRL_Z));

        traits.addTrait(
                new Restrict(Command.DISABLE, "Setup", new Expression(setup.getVarName() + "=" + max), HotKey.CTRL_A));

        traits.addTrait(new GlobalKey("Set Setup", null, HotKey.CTRL_Z, CustomHotKey.DISABLE, setSetup));

        traits.addTrait(new DynamicProperty(setup, max, 0, max, false,
                new DynamicPropertyTrigger("Increase", HotKey.CTRL_A, DynPropTriggerType.INCREMENT, 1),
                new DynamicPropertyTrigger("Decrease", HotKey.CTRL_Z, DynPropTriggerType.INCREMENT, -1)));

        traits.addTrait(new GlobalKey("Set Setup", null, HotKey.CTRL_A, CustomHotKey.ENABLE, setSetup));

        traits.addTrait(new Report("<" + Variable.PLAYER + "> changes setup of " + Variable.BOX + " on " //
                + SystemProperty.CURRENT_MAP + " to " + setup + " from " + setup.getOldVar(), HotKey.CTRL_A,
                HotKey.CTRL_Z));

        traits.addTrait(new Label("Position", setup.getVar(), SystemProperty.MAP_PIECE + " (" + Variable.LABEL + ")",
                "strSetup", null, null, Font.DIALOG, 24, false, false, null, Color.BLACK, Position.BOTTOM,
                Position.BOTTOM, -7, Position.CENTER, Position.CENTER, 0, 0));

        traits.addTrait(new NoStack(NoStackType.NORMALLY_NORMALLY_NEVER));

        return new PrototypeDefinition(prototype, traits);
    }
}
