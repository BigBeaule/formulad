package com.bigb.vassal.formuled.element.trait;

import com.bigb.vassal.formuled.element.Expression;
import com.bigb.vassal.formuled.element.trait.DynamicProp.DynamicPropertyTrigger;

import lombok.NonNull;

public class GlobalProp extends AbstractTrait {
    public GlobalProp(@NonNull String description, @NonNull Expression property, Expression mapName, int min, int max,
            DynamicPropertyTrigger... triggers) {
        
        super("setprop", property, internalTraitParams(true, min, max, false), internalTraitParams(triggers), description,
                "Named Map", mapName);
    }
}
