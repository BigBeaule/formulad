package com.bigb.vassal.formuled.element.trait;

import com.bigb.vassal.formuled.configuration.Color;
import com.bigb.vassal.formuled.element.HotKey;

/**
 * 
 */
public class MovementTrail extends AbstractTrait {
    public MovementTrail(Color circle, Color line) {
        super("footprint", //
                null, // Key command
                null, // Menu command
                true, true, 6, circle, line, //
                100, // Selected transparency
                50, // Unselected transparency
                20, // Off map trail display
                30, // Off map trails display
                2.0, // Line thickness
                null, // On key
                null, // Off key
                HotKey.CTRL_T); // Reset key
    }

    @Override
    protected Object closeTrait() {
        return Traits.exportOptions(true, null, 0);
    }
}
