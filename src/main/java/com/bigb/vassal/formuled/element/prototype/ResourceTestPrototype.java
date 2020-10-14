package com.bigb.vassal.formuled.element.prototype;

import java.util.Collections;

import com.bigb.vassal.formuled.element.CustomHotKey;
import com.bigb.vassal.formuled.element.Expression;
import com.bigb.vassal.formuled.element.enums.CarResource;
import com.bigb.vassal.formuled.element.enums.ExpressionVariable;
import com.bigb.vassal.formuled.element.enums.Prototype;
import com.bigb.vassal.formuled.element.enums.Stack;
import com.bigb.vassal.formuled.element.enums.SystemProperty;
import com.bigb.vassal.formuled.element.enums.Variable;
import com.bigb.vassal.formuled.element.piece.Panel;
import com.bigb.vassal.formuled.element.piece.PieceSlot;
import com.bigb.vassal.formuled.element.piece.PieceWindow;
import com.bigb.vassal.formuled.element.piece.PieceWindow.Tab;
import com.bigb.vassal.formuled.element.trait.CalculatedProp;
import com.bigb.vassal.formuled.element.trait.CreatePiece;
import com.bigb.vassal.formuled.element.trait.GlobalKey;
import com.bigb.vassal.formuled.element.trait.Report;
import com.bigb.vassal.formuled.element.trait.Traits;
import com.bigb.vassal.formuled.element.trait.TriggerAction;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
class ResourceTestPrototype {
    static PrototypeDefinition buildPrototype(Prototype prototype, CarResource resource, int normalThreshold,
            int rainTreshold, CustomHotKey rollCommand, CustomHotKey loseCommand, int nextId) {

        String next = "nextResource" + resource;
        String threshold = "threshold" + resource;
        String nextVar = ExpressionVariable.getVariableExpression(next, null, true);
        String thresholdVar = ExpressionVariable.getVariableExpression(threshold, null, true);

        Traits traits = new Traits();

        Expression loseExpression = new Expression(Variable.D20 + " <= " + thresholdVar, true);
        Expression closeExpression = new Expression(Variable.D20 + " - 1 == " + thresholdVar, true);
        Expression nearExpression = new Expression(Variable.D20 + " - 2 == " + thresholdVar, true);
        Expression easyExpression = new Expression(Variable.D20 + " - 2 > " + thresholdVar, true);

        traits.addTrait(new TriggerAction("Failed Test Result", null, null, loseExpression,
                Collections.singletonList(rollCommand), Collections.singletonList(loseCommand)));
        traits.addTrait(new TriggerAction("Close Test Result", null, null, closeExpression,
                Collections.singletonList(rollCommand), Collections.singletonList(CustomHotKey.CLOSE_TEST)));
        traits.addTrait(new TriggerAction("Near Test Result", null, null, nearExpression,
                Collections.singletonList(rollCommand), Collections.singletonList(CustomHotKey.NEAR_TEST)));
        traits.addTrait(new TriggerAction("Easy Test Result", null, null, easyExpression,
                Collections.singletonList(rollCommand), Collections.singletonList(CustomHotKey.EASY_TEST)));

        traits.addTrait(new Report("Failed test", "<span style=\"color:red;\"><b>BOOM</b></span>", loseCommand));
        traits.addTrait(new GlobalKey("Lose " + resource.getType(), null, loseCommand, CustomHotKey.INCREASE,
                new Expression(
                        SystemProperty.CURRENT_MAP.getVarName() + "==\"" + Variable.CAR + "\" && "
                                + Variable.BOX.getVarName() + "==\"" + resource + "\" && n==\"" + nextVar + '"',
                        true)));

        traits.addTrait(new CalculatedProp(next, new Expression(
                getGlobalResourceProperty("setup", resource) + "-" + getGlobalResourceProperty("used", resource),
                true)));

        traits.addTrait(new CalculatedProp(threshold, new Expression("(" + Variable.WEATHER.getVarName() + " == \""
                + Variable.RAINY.getVarName() + "\") ? " + rainTreshold + " : " + normalThreshold, true)));

        
        if (resource != CarResource.HOLDING) {
            traits.addTrait(new CreatePiece("Add Hazard", nextId, null, loseCommand, true, Stack.BELOW, //
                    PieceWindow.NAME, //
                    PieceWindow.WINDOW_NAME + '/' + Tab.NAME + '/' + Panel.NAME, //
                    PieceWindow.MARKERS + '/' + PieceSlot.NAME, //
                    PieceWindow.MARKER_OIL //
            ));
        }
        return new PrototypeDefinition(prototype, traits);
    }

    private static String getGlobalResourceProperty(String prefix, CarResource resource) {
        return "GetMapProperty(\"" + prefix + resource.getType() + "\"," + Variable.CAR.getVarName() + ")";
    }
}
