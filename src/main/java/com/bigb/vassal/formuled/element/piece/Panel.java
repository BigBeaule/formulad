package com.bigb.vassal.formuled.element.piece;

import com.bigb.vassal.formuled.element.BaseElement;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.util.List;

/**
 * 
 */
public class Panel extends BaseElement {
    @JacksonXmlProperty(isAttribute = true)
    private final String entryName;
    
    @JacksonXmlProperty(isAttribute = true)
    private final boolean fixed;
    
    @JacksonXmlProperty(isAttribute = true)
    private final int nColumns;
    
    @JacksonXmlProperty(isAttribute = true)
    private final boolean vert;
    
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = WIDGET + "PieceSlot")
    private final List<PieceSlot> pieces;

    public Panel(String entryName, int nbColumns, boolean fixed, boolean vertical, List<PieceSlot> pieces) {
        this.entryName = entryName;
        this.nColumns = nbColumns;
        this.vert = vertical;
        this.fixed = fixed;
        this.pieces = pieces;
    }
}
