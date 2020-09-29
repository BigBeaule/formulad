package com.bigb.vassal.formuled.element;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

/**
 * 
 */
public class GamePieceImageDefinitions extends BaseElement {
    private static final String PREFIX = MODULE + "gamepieceimage.";
    public static final String NAME = PREFIX + "GamePieceImageDefinitions";

    @JacksonXmlProperty(localName = PREFIX + "ColorManager")
    private final EmptyElement colorManager = EmptyElement.ELEMENT;
    
    @JacksonXmlProperty(localName = PREFIX + "FontManager")
    private final FontManager fontManager = new FontManager();
    
    @JacksonXmlProperty(localName = PREFIX + "GamePieceLayoutsContainer")
    private final EmptyElement layoutsContainer = EmptyElement.ELEMENT;

    private static final class FontManager extends BaseElement {
        @JacksonXmlProperty(localName = PREFIX + "FontStyle")
        private final FontStyle fontStyle = new FontStyle();
    }

    private static final class FontStyle extends BaseElement {
        @JacksonXmlProperty(isAttribute = true)
        private final String name = "Default";
        
        @JacksonXmlProperty(isAttribute = true)
        private final String style = "Dialog,0,12,false";
    }
}
