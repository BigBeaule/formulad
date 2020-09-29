package com.bigb.vassal.formuled.element.prototype;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.IntStream;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

import com.bigb.vassal.formuled.element.CustomHotKey;
import com.bigb.vassal.formuled.element.Expression;
import com.bigb.vassal.formuled.element.HotKey;
import com.bigb.vassal.formuled.element.enums.Command;
import com.bigb.vassal.formuled.element.enums.DynPropTriggerType;
import com.bigb.vassal.formuled.element.enums.NoStackType;
import com.bigb.vassal.formuled.element.enums.Prototype;
import com.bigb.vassal.formuled.element.enums.SystemProperty;
import com.bigb.vassal.formuled.element.enums.Variable;
import com.bigb.vassal.formuled.element.trait.Delete;
import com.bigb.vassal.formuled.element.trait.DynamicProperty;
import com.bigb.vassal.formuled.element.trait.GlobalHotKey;
import com.bigb.vassal.formuled.element.trait.GlobalKey;
import com.bigb.vassal.formuled.element.trait.MarkMoved;
import com.bigb.vassal.formuled.element.trait.Marker;
import com.bigb.vassal.formuled.element.trait.NoStack;
import com.bigb.vassal.formuled.element.trait.Report;
import com.bigb.vassal.formuled.element.trait.Restrict;
import com.bigb.vassal.formuled.element.trait.Rotate;
import com.bigb.vassal.formuled.element.trait.Traits;
import com.bigb.vassal.formuled.element.trait.TriggerAction;
import com.bigb.vassal.formuled.element.trait.DynamicProperty.DynamicPropertyTrigger;
import com.bigb.vassal.formuled.element.trait.Layer.LayerBuilder;

/**
 * 
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
final class CarPrototype extends AbstractGearPrototype {
    private static final HotKey[] F_KEYS = {HotKey.F1, HotKey.F2, HotKey.F3, HotKey.F4, HotKey.F5, HotKey.F6};

    static PrototypeDefinition buildPrototype() {
        Traits traits = new Traits();
        traits.addTrait(getCarGearTrigger(6));
        traits.addTrait(getCarGearTrigger(5));
        traits.addTrait(getCarGearTrigger(4));
        traits.addTrait(getCarGearTrigger(3));
        traits.addTrait(getCarGearTrigger(2));
        traits.addTrait(getCarGearTrigger(1));
        traits.addTrait(getCarGearGlobalHotKey(6));
        traits.addTrait(getCarGearGlobalHotKey(5));
        traits.addTrait(getCarGearGlobalHotKey(4));
        traits.addTrait(getCarGearGlobalHotKey(3));
        traits.addTrait(getCarGearGlobalHotKey(2));
        traits.addTrait(getCarGearGlobalHotKey(1));

        traits.addTrait(new TriggerAction(null, "Roll", HotKey.CTRL_R, null, Collections.singletonList(HotKey.CTRL_R),
                Arrays.asList(CustomHotKey.ROLL_1, CustomHotKey.ROLL_2, CustomHotKey.ROLL_3, CustomHotKey.ROLL_4,
                        CustomHotKey.ROLL_5, CustomHotKey.ROLL_6)));

        Command disable = Command.DISABLE;
        Variable var = Variable.STOPS;
        traits.addTrait(new Restrict(disable, "Stops", new Expression(var.getVarName() + "=4"), HotKey.CTRL_S));
        traits.addTrait(
                new Restrict(disable, "Stops", new Expression(var.getVarName() + "=0"), HotKey.CTRL_C, HotKey.CTRL_X));

        var = Variable.GEAR;
        traits.addTrait(new Restrict(disable, "Gear", new Expression(var.getVarName() + "=6"), HotKey.CTRL_A));
        traits.addTrait(new Restrict(disable, "Gear", new Expression(var.getVarName() + "=0"), HotKey.CTRL_Z));

        traits.addTrait(new Marker(Variable.IS_CAR.getVarName(), Boolean.TRUE));

        Expression isCarGears = new Expression(
                SystemProperty.CURRENT_MAP.getVarName() + "=" + Variable.CAR + " && " + Prototype.DASH_GEARS + "=true");
        traits.addTrait(new GlobalKey("DecGear", null, HotKey.CTRL_Z, CustomHotKey.DECREASE_GEAR, isCarGears, true));
        traits.addTrait(new GlobalKey("IncGear", null, HotKey.CTRL_A, CustomHotKey.INCREASE_GEAR, isCarGears, true));

        traits.addTrait(new DynamicProperty(Variable.STOPS, 0, 0, 4, false,
                new DynamicPropertyTrigger("Corner Stops [+1]", HotKey.CTRL_S, DynPropTriggerType.INCREMENT, 1),
                new DynamicPropertyTrigger("Corner Stops [-1]", HotKey.CTRL_X, DynPropTriggerType.INCREMENT, -1),
                new DynamicPropertyTrigger("Corner Stops [Reset]", HotKey.CTRL_C, DynPropTriggerType.SET_VALUE, 0)));

        traits.addTrait(new DynamicProperty(Variable.GEAR, 1, 0, 6, false,
                new DynamicPropertyTrigger("Gear [Up]", HotKey.CTRL_A, DynPropTriggerType.INCREMENT, 1),
                new DynamicPropertyTrigger("Gear [Down]", HotKey.CTRL_Z, DynPropTriggerType.INCREMENT, -1),
                getGearTrigger(0), getGearTrigger(1), getGearTrigger(2), getGearTrigger(3), getGearTrigger(4),
                getGearTrigger(5), getGearTrigger(6)));

        traits.addTrait(new NoStack(NoStackType.NORMALLY));
        traits.addTrait(new Marker(Variable.LAYER.getVarName(), Variable.CAR.getVarName()));

        traits.addTrait(new Report("Erase Move Path",
                "<" + Variable.PLAYER + "> erases movement path on " + SystemProperty.FULL_PIECE.getNewVar(),
                HotKey.CTRL_T));
        traits.addTrait(new Report("Stops", "<" + Variable.PLAYER + "> changes stops on " + //
                SystemProperty.FULL_PIECE.getNewVar() + " from " + Variable.STOPS.getOldVar(), HotKey.CTRL_S,
                HotKey.CTRL_X, HotKey.CTRL_C));
        traits.addTrait(new Report("Report Gear", "<" + Variable.PLAYER + "> selects gear on " + //
                SystemProperty.FULL_PIECE.getNewVar() + " from Gear " + Variable.GEAR.getOldVar(), HotKey.CTRL_A,
                HotKey.CTRL_Z, CustomHotKey.GEAR_0, CustomHotKey.GEAR_1, CustomHotKey.GEAR_2, CustomHotKey.GEAR_3,
                CustomHotKey.GEAR_4, CustomHotKey.GEAR_5, CustomHotKey.GEAR_6));

        traits.addTrait(new MarkMoved("Reset Movement Trail", HotKey.CTRL_T));
        traits.addTrait(new Rotate("Rotate", 36, HotKey.CTRL_W, "Rotate CW", HotKey.CTRL_Q, "Rotate CCW", 0));
        traits.addTrait(new TriggerAction("Rotate CCW 90", "Rotate CCW 90˚", HotKey.CTRL_SHIFT_Q, null,
                Collections.singletonList(HotKey.CTRL_SHIFT_Q), Collections.singletonList(HotKey.CTRL_Q), 9, null,
                null));
        traits.addTrait(new TriggerAction("Rotate CW 90", "Rotate CW 90˚", HotKey.CTRL_SHIFT_W, null,
                Collections.singletonList(HotKey.CTRL_SHIFT_W), Collections.singletonList(HotKey.CTRL_W), 9, null,
                null));

        LayerBuilder cornerBuilder = new LayerBuilder("Corner Stops");
        cornerBuilder.followExpression(new Expression(Variable.STOPS.getVarName()), 0);
        cornerBuilder.resetLevel("Corner Stops [Reset]", HotKey.CTRL_C, 1);
        cornerBuilder.increaseLevel("Corner Stops [+1]", HotKey.CTRL_S);
        cornerBuilder.decreaseLevel("Corner Stops [-1]", HotKey.CTRL_X);
        IntStream.range(0, 5).forEach(i -> cornerBuilder.addLevel("Bandiera_" + i + ".png",
                i == 0 ? StringUtils.EMPTY : " Stopped " + i, true));
        traits.addTrait(cornerBuilder.build(1));

        LayerBuilder gearBuilder = new LayerBuilder("Gears");
        gearBuilder.followExpression(new Expression(Variable.GEAR.getVarName()), 0);
        gearBuilder.increaseLevel("Gear [Up]", HotKey.CTRL_A);
        gearBuilder.decreaseLevel("Gear [Down]", HotKey.CTRL_Z);
        IntStream.range(0, 7).forEach(i -> gearBuilder.addLevel(i + "a_Marcia.png", " Gear " + i, true));
        traits.addTrait(gearBuilder.build(2));

        traits.addTrait(new Delete());
        return new PrototypeDefinition(Prototype.CAR, traits);
    }

    protected static TriggerAction getCarGearTrigger(int gear) {
        return new TriggerAction(null, null, null, new Expression(Variable.GEAR.getVarName() + "=" + gear),
                Collections.<HotKey>singletonList(CustomHotKey.ROLLS[gear - 1]),
                Collections.<HotKey>singletonList(CustomHotKey.DO_ROLLS[gear - 1]));
    }

    protected static GlobalHotKey getCarGearGlobalHotKey(int gear) {
        return new GlobalHotKey(null, null, CustomHotKey.DO_ROLLS[gear - 1], F_KEYS[gear - 1]);
    }
}
