package com.bigb.vassal.formuled.element.trait;

/**
 * 
 */
public interface Trait {
    static char SEP = '\t';
    Object getClosingValue();
    String startExport(int level);
    String endExport(int level);
}
