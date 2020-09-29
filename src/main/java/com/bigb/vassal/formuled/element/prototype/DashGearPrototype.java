package com.bigb.vassal.formuled.element.prototype;

import java.util.stream.IntStream;

import com.bigb.vassal.formuled.element.CustomHotKey;
import com.bigb.vassal.formuled.element.Expression;
import com.bigb.vassal.formuled.element.enums.DynPropTriggerType;
import com.bigb.vassal.formuled.element.enums.NoStackType;
import com.bigb.vassal.formuled.element.enums.Prototype;
import com.bigb.vassal.formuled.element.enums.SystemProperty;
import com.bigb.vassal.formuled.element.enums.Variable;
import com.bigb.vassal.formuled.element.trait.Button;
import com.bigb.vassal.formuled.element.trait.DynamicProperty;
import com.bigb.vassal.formuled.element.trait.GlobalKey;
import com.bigb.vassal.formuled.element.trait.Marker;
import com.bigb.vassal.formuled.element.trait.NoStack;
import com.bigb.vassal.formuled.element.trait.Traits;
import com.bigb.vassal.formuled.element.trait.DynamicProperty.DynamicPropertyTrigger;
import com.bigb.vassal.formuled.element.trait.Layer.LayerBuilder;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * 
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
class DashGearPrototype extends AbstractGearPrototype {
    static PrototypeDefinition buildPrototypeV1() {
        return buildPrototype("dash-gears", DASH_V1_GEAR_POS);
    }

    static PrototypeDefinition buildPrototypeV2() {
        return buildPrototype("dash-gear", DASH_V2_GEAR_POS);
    }

    private static PrototypeDefinition buildPrototype(String imagePrefix, int[][] gearsPosition) {
        Traits traits = new Traits();
        traits.addTrait(new Marker(Prototype.DASH_GEARS.getId(), String.valueOf(true)));
        traits.addTrait(getGearGlobalKey(6));
        traits.addTrait(getGearGlobalKey(5));
        traits.addTrait(getGearGlobalKey(4));
        traits.addTrait(getGearGlobalKey(3));
        traits.addTrait(getGearGlobalKey(2));
        traits.addTrait(getGearGlobalKey(1));
        traits.addTrait(getGearGlobalKey(0));
        traits.addTrait(getGearButton(6, gearsPosition));
        traits.addTrait(getGearButton(5, gearsPosition));
        traits.addTrait(getGearButton(4, gearsPosition));
        traits.addTrait(getGearButton(3, gearsPosition));
        traits.addTrait(getGearButton(2, gearsPosition));
        traits.addTrait(getGearButton(1, gearsPosition));
        traits.addTrait(getGearButton(0, gearsPosition));
        traits.addTrait(new NoStack(NoStackType.NEVER_NORMALLY_NEVER));
        traits.addTrait(new DynamicProperty(Variable.GEAR, 1, 0, 6, false, getGearTrigger(0), getGearTrigger(1),
                getGearTrigger(2), getGearTrigger(3), getGearTrigger(4), getGearTrigger(5), getGearTrigger(6),
                new DynamicPropertyTrigger(null, CustomHotKey.INCREASE_GEAR, DynPropTriggerType.INCREMENT, 1),
                new DynamicPropertyTrigger(null, CustomHotKey.DECREASE_GEAR, DynPropTriggerType.INCREMENT, -1)));

        LayerBuilder layerBuilder = new LayerBuilder("Gears");
        layerBuilder.followExpression(new Expression(Variable.GEAR.getVarName()), 0);
        IntStream.range(0, 7).forEach(gear -> layerBuilder.addLevel(imagePrefix + gear + ".png"));
        traits.addTrait(layerBuilder.build(2));

        return new PrototypeDefinition(Prototype.DASH_GEARS, traits);
    }

    private static GlobalKey getGearGlobalKey(int gear) {
        Variable car = Variable.CAR;
        CustomHotKey gearKey = CustomHotKey.GEAR_KEYS[gear];
        return new GlobalKey("Gear " + gear, null, gearKey, gearKey,
                new Expression(SystemProperty.CURRENT_MAP.getVarName() + "=" + CIRCUIT_MAP + " && " + car.getVarName()
                        + "=" + car + " && " + Variable.IS_CAR.getVarName() + "=true"));
    }

    private static Button getGearButton(int gear, int[][] gearsPositions) {
        CustomHotKey gearKey = CustomHotKey.GEAR_KEYS[gear];
        int[] pos = gearsPositions[gear];

        return new Button("Gear " + gear, gearKey, pos[0], pos[1], pos[2], pos[3]);
    }

    private static final int[][] DASH_V1_GEAR_POS = { //
            {0, 118, -582, -59}, //
            {50, 118, -532, -59}, //
            {180, 118, -352, -59}, //
            {180, 118, -172, -59}, //
            {180, 118, 8, -59}, //
            {180, 118, 188, -59}, //
            {180, 118, 368, -59} //
    };

    private static final int[][] DASH_V2_GEAR_POS = { //
            {22, 20, 9, 178}, //
            {80, 76, -100, 148}, //
            {69, 70, 49, 80}, //
            {98, 92, -112, -31}, //
            {84, 78, 44, -112}, //
            {86, 70, -112, -191}, //
            {85, 74, 44, -249} //
    };
}
