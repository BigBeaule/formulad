package com.bigb.vassal.formuled.element.trait;

import com.bigb.vassal.formuled.element.HotKey;
import com.bigb.vassal.formuled.element.enums.Command;

/**
 * 
 */
public class Delete extends AbstractTrait {
    public Delete() {
        super("delete", Command.DELETE, HotKey.CTRL_D);
    }
}
