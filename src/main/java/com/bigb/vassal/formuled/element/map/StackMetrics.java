package com.bigb.vassal.formuled.element.map;

import com.bigb.vassal.formuled.element.PositionnedElement;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

/**
 * 
 */
public class StackMetrics extends PositionnedElement {
    @JacksonXmlProperty(isAttribute = true)
    private final boolean disabled = false;
    
    public StackMetrics() {
        super(new Position(38, 0), new Position(39, 0), new Position(40, 0), new Position(37, 0), 6, 18, 2, 4);
    }

}
