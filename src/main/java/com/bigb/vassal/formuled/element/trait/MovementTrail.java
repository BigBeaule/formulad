package com.bigb.vassal.formuled.element.trait;

import com.bigb.vassal.formuled.configuration.Color;
import com.bigb.vassal.formuled.element.HotKey;

/**
 * 
 */
public class MovementTrail extends AbstractTrait {
    public MovementTrail(Color circle, Color line) {
        super("footprint", HotKey.CTRL_T, "Movement Trail", true, true, 6, circle, line, //
                100, // Selected transparency
                50, // Unselected transparency
                20, // Off map trail display
                30, // Off map trails display
                2.0); // Line thickness
    }
    
    @Override
    protected Object closeTrait() {
        return Traits.exportOptions(true, null, 0);
    }
}
