package com.bigb.vassal.formuled.element.enums;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * 
 */
public interface ExpressionVariable {
    String getVarName();
    
    @JsonValue
    default String getVar() {
        return getVariableExpression(getVarName(), null, true);
    }
    
    default String getOldVar() {
        return getVariableExpression(getVarName(), "old", true);
    }
    
    default String getNewVar() {
        return getVariableExpression(getVarName(), "new", true);
    }
    
    static String getVariableExpression(String var, String prefix, boolean dollars) {
        String expression = prefix == null ? var : (prefix + var);
        return dollars ? "$" + expression + "$" : expression;
    }
}
