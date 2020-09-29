package com.bigb.vassal.formuled.element.piece;

import com.bigb.vassal.formuled.element.BaseElement;
import com.bigb.vassal.formuled.element.trait.Traits;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;

/**
 * 
 */
public class PieceSlot extends BaseElement {
    @JacksonXmlProperty(isAttribute = true)
    private final String entryName;
    
    @JacksonXmlProperty(isAttribute = true)
    private final int gpid;
    
    @JacksonXmlProperty(isAttribute = true)
    private final int height;
    
    @JacksonXmlProperty(isAttribute = true)
    private final int width;
    
    @JacksonXmlText
    private final Traits traits;

    public PieceSlot(String entryName, int height, int width, Traits traits) {
        this.entryName = entryName;
        this.height = height;
        this.width = width;
        this.traits = traits;
        this.gpid = traits.getUniqueId();
    }
    
    
}
