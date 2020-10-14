package com.bigb.vassal.formuled.element.enums;

import lombok.RequiredArgsConstructor;

/**
 * 
 */
@RequiredArgsConstructor
public enum SystemProperty implements ExpressionVariable {
    BASIC_PIECE("BasicName"), // $%&*#@^$*(&@
    FULL_PIECE("PieceName"), // $%&*#@^$*(&@
    MAP_PIECE("pieceName"), // $%&*#@^$*(&@
    LOCATION("LocationName"), //
    CURRENT_MAP("CurrentMap"); //

    private final String var;

    @Override
    public String getVarName() {
        return var;
    }

    @Override
    public String toString() {
        return getVar();
    }
}
