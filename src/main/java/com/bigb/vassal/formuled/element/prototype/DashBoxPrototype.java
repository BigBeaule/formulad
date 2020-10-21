package com.bigb.vassal.formuled.element.prototype;

import com.bigb.vassal.formuled.element.BaseElement;
import com.bigb.vassal.formuled.element.CustomHotKey;
import com.bigb.vassal.formuled.element.Expression;
import com.bigb.vassal.formuled.element.enums.Command;
import com.bigb.vassal.formuled.element.enums.DynPropTriggerType;
import com.bigb.vassal.formuled.element.enums.NoStackType;
import com.bigb.vassal.formuled.element.enums.Prototype;
import com.bigb.vassal.formuled.element.enums.SystemProperty;
import com.bigb.vassal.formuled.element.enums.Variable;
import com.bigb.vassal.formuled.element.trait.Button;
import com.bigb.vassal.formuled.element.trait.DynamicProp;
import com.bigb.vassal.formuled.element.trait.DynamicProp.DynamicPropertyTrigger;
import com.bigb.vassal.formuled.element.trait.Layer.LayerBuilder;
import com.bigb.vassal.formuled.element.trait.NoStack;
import com.bigb.vassal.formuled.element.trait.Report;
import com.bigb.vassal.formuled.element.trait.Restrict;
import com.bigb.vassal.formuled.element.trait.Traits;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * 
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
class DashBoxPrototype {
    static PrototypeDefinition buildPrototypeV1() {
        return buildPrototype("unused.png", "unavailable.png", "used.png", 40, 40, -20, -20);
    }

    static PrototypeDefinition buildPrototypeV2() {
        return buildPrototype("unused-small.png", "unavailable-small.png", "used-small.png", 21, 21, -10, -10);
    }

    private static PrototypeDefinition buildPrototype(String unusedImage, String unavailableImage, String usedImage,
            int buttonWidth, int buttonHeight, int buttonOffsetX, int buttonOffsetY) {

        Traits traits = new Traits();
        traits.addTrait(new Restrict(Command.DISABLE, "Disable Box",
                new Expression(Variable.DISABLED.getVarName() + "==1", true), CustomHotKey.INCREASE));

        traits.addTrait(new DynamicProp(Variable.DISABLED, 0, 0, 1, true, //
                new DynamicPropertyTrigger(null, CustomHotKey.ENABLE, DynPropTriggerType.SET_VALUE, 0), //
                new DynamicPropertyTrigger(null, CustomHotKey.DISABLE, DynPropTriggerType.SET_VALUE, 1)));

        traits.addTrait(new Report(BaseElement.PLAYER_CHAT + " " + SystemProperty.CURRENT_MAP + ": "
                + SystemProperty.FULL_PIECE.getNewVar(), CustomHotKey.INCREASE));

        traits.addTrait(new NoStack(NoStackType.NEVER_NORMALLY_NEVER));
        traits.addTrait(
                new Button(null, CustomHotKey.INCREASE, buttonWidth, buttonHeight, buttonOffsetX, buttonOffsetY));

        LayerBuilder layerBuilder = new LayerBuilder("Disabled").loopLevel();
        layerBuilder.addLevel(unusedImage).addLevel(unavailableImage, " (disabled)", true);
        layerBuilder.followExpression(new Expression(Variable.DISABLED.getVarName()), 0);
        layerBuilder.increaseLevel(null, CustomHotKey.TOGGLE_ENABLED);
        traits.addTrait(layerBuilder.build(1));

        layerBuilder = new LayerBuilder("Box").loopLevel();
        layerBuilder.addLevel(unusedImage, " unchecked", true).addLevel(usedImage, " checked", true);
        layerBuilder.increaseLevel(null, CustomHotKey.INCREASE);
        traits.addTrait(layerBuilder.build(1));

        return new PrototypeDefinition(Prototype.DASH_BOX, traits);
    }
}
