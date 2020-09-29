package com.bigb.vassal.formuled.element.trait;

import com.bigb.vassal.formuled.element.HotKey;

/**
 * 
 */
public class Report extends AbstractTrait {
    public Report(String message, HotKey... reportsOn) {
        this(null, message, reportsOn);
    }
    
    public Report(String description, String message, HotKey... reportsOn) {
        super("report", internalTraitParams(reportsOn), message, null, null, description);
    }
    
    @Override
    protected Object closeTrait() {
        return -1;
    }
}
