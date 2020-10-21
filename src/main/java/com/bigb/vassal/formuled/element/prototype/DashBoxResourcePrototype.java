package com.bigb.vassal.formuled.element.prototype;

import com.bigb.vassal.formuled.element.CustomHotKey;
import com.bigb.vassal.formuled.element.Expression;
import com.bigb.vassal.formuled.element.enums.DynPropTriggerType;
import com.bigb.vassal.formuled.element.enums.ExpressionVariable;
import com.bigb.vassal.formuled.element.enums.Prototype;
import com.bigb.vassal.formuled.element.enums.Variable;
import com.bigb.vassal.formuled.element.trait.CalculatedProp;
import com.bigb.vassal.formuled.element.trait.DynamicProp.DynamicPropertyTrigger;
import com.bigb.vassal.formuled.element.trait.GlobalProp;
import com.bigb.vassal.formuled.element.trait.PrototypeRef;
import com.bigb.vassal.formuled.element.trait.Traits;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * 
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
class DashBoxResourcePrototype {
    private static final String USED_VALUE = "usedValue";
    private static final String USED_VALUE_VAR = ExpressionVariable.getVariableExpression(USED_VALUE, null, true);

    static PrototypeDefinition buildPrototype() {
        Traits traits = new Traits();
        traits.addTrait(new CalculatedProp(USED_VALUE, new Expression("(Box_Level == 2) ? 1 : -1", true)));
        traits.addTrait(new PrototypeRef(Prototype.DASH_BOX));
        traits.addTrait(new GlobalProp("Set Used Resource",
                new Expression("\"used\" + " + Variable.BOX.getVarName(), true),
                new Expression(Variable.CAR.getVarName(), true), 0, 12, //
                new DynamicPropertyTrigger(null, CustomHotKey.INCREASE, DynPropTriggerType.INCREMENT, USED_VALUE_VAR)));

        return new PrototypeDefinition(Prototype.DASH_BOX_RESOURCE, traits);
    }
}
