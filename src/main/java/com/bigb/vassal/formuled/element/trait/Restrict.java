package com.bigb.vassal.formuled.element.trait;

import com.bigb.vassal.formuled.element.Expression;
import com.bigb.vassal.formuled.element.HotKey;
import com.bigb.vassal.formuled.element.enums.Command;

/**
 * 
 */
public class Restrict extends AbstractTrait {
    public Restrict(Command command, String description, Expression expression, HotKey... restrictedCommands) {
        super("hideCmd", description, command, expression, internalTraitParams(restrictedCommands));
    }
}
