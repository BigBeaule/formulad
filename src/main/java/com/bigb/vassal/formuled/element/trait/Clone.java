package com.bigb.vassal.formuled.element.trait;

import com.bigb.vassal.formuled.element.HotKey;
import com.bigb.vassal.formuled.element.enums.Command;

/**
 * 
 */
public class Clone extends AbstractTrait {
    public Clone() {
        super("clone", Command.CLONE, HotKey.CTRL_C);
    }
}
