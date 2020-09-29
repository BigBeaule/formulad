package com.bigb.vassal.formuled.element;

import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * 
 */
@RequiredArgsConstructor
public abstract class PositionnedElement extends BaseElement {
    @JacksonXmlProperty(isAttribute = true)
    private final Position top;
    
    @JacksonXmlProperty(isAttribute = true)
    private final Position up;
    
    @JacksonXmlProperty(isAttribute = true)
    private final Position bottom;
    
    @JacksonXmlProperty(isAttribute = true)
    private final Position down;
    
    @JacksonXmlProperty(isAttribute = true)
    private final int exSepX;
    
    @JacksonXmlProperty(isAttribute = true)
    private final int exSepY;
    
    @JacksonXmlProperty(isAttribute = true)
    private final int unexSepX;
    
    @JacksonXmlProperty(isAttribute = true)
    private final int unexSepY;

    @Getter
    @RequiredArgsConstructor
    public static final class Position {
        private final int x;
        private final int y;

        @JsonValue
        public String getCoordinates() {
            return new StringBuilder().append(x).append(',').append(y).toString();
        }
    }
}
