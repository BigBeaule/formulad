package com.bigb.vassal.formuled.element.prototype;

import com.bigb.vassal.formuled.element.BaseElement;
import com.bigb.vassal.formuled.element.CustomHotKey;
import com.bigb.vassal.formuled.element.enums.DynPropTriggerType;
import com.bigb.vassal.formuled.element.trait.DynamicProp.DynamicPropertyTrigger;

/**
 * 
 */
abstract class AbstractGearPrototype extends BaseElement {
    protected static DynamicPropertyTrigger getGearTrigger(int gear) {
        return new DynamicPropertyTrigger(null, CustomHotKey.GEAR_KEYS[gear], DynPropTriggerType.SET_VALUE, gear);
    }
}
