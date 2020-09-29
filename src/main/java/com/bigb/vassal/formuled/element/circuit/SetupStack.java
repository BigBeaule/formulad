package com.bigb.vassal.formuled.element.circuit;

import com.bigb.vassal.formuled.element.BaseElement;
import com.bigb.vassal.formuled.element.map.BaseMap;
import com.bigb.vassal.formuled.element.piece.PieceSlot;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import lombok.RequiredArgsConstructor;

/**
 * 
 */
@RequiredArgsConstructor
public class SetupStack extends BaseElement {
    public static final String NAME = BaseMap.MAP_PREFIX + "SetupStack";
    
    @JacksonXmlProperty(isAttribute = true)
    private final String name;
    
    @JacksonXmlProperty(isAttribute = true)
    private final boolean useGridLocation = false;
    
    @JacksonXmlProperty(isAttribute = true)
    private final int x;
    
    @JacksonXmlProperty(isAttribute = true)
    private final int y;
    
    @JacksonXmlProperty(localName = WIDGET + "PieceSlot")
    private final PieceSlot piece;
}
