package com.bigb.vassal.formuled.element.trait;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

import com.bigb.vassal.formuled.element.HotKey;
import com.bigb.vassal.formuled.element.enums.DynPropTriggerType;
import com.bigb.vassal.formuled.element.enums.Variable;

/**
 * 
 */
public class DynamicProperty extends AbstractTrait {
    private final Object value;

    public DynamicProperty(Variable name, int value, int minValue, int maxValue, boolean wrap,
            DynamicPropertyTrigger... triggers) {

        super("PROP", name.getVarName(), internalTraitParams(true, minValue, maxValue, wrap),
                internalTraitParams(triggers));

        this.value = value;
    }

    public DynamicProperty(Variable name, DynamicPropertyTrigger... triggers) {
        super("PROP", name.getVarName(), internalTraitParams(false, null, null, false), internalTraitParams(triggers));
        this.value = null;
    }

    @Override
    protected Object closeTrait() {
        return value;
    }

    public static final class DynamicPropertyTrigger {
        private final List<Object> triggerParams = new ArrayList<>();

        public DynamicPropertyTrigger(String menuCommand, HotKey keyCommand, DynPropTriggerType type, Object value) {
            triggerParams.add(menuCommand);
            triggerParams.add(keyCommand);
            triggerParams.add(type.getValue() + ',' + String.valueOf(value));
        }

        @Override
        public String toString() {
            return StringUtils.join(triggerParams, ':');
        }
    }
}
