package com.bigb.vassal.formuled.element;

import com.bigb.vassal.formuled.element.enums.Variable;

import lombok.RequiredArgsConstructor;

/**
 * 
 */
@RequiredArgsConstructor
public abstract class BaseElement {
    protected static final String VASSAL = "VASSAL.";
    protected static final String MODULE = VASSAL + "build.module.";
    protected static final String WIDGET = VASSAL + "build.widget.";
    
    protected static final String CIRCUIT_MAP = "Circuit";
    public static final String PLAYER_CHAT = "<b>" + Variable.PLAYER + "</b> ";
    

    private static int nextId = 0;

    protected int getNextId() {
        return nextId++;
    }
}
