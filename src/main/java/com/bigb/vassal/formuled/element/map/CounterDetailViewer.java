package com.bigb.vassal.formuled.element.map;

import com.bigb.vassal.formuled.configuration.Color;
import com.bigb.vassal.formuled.element.BaseElement;
import com.bigb.vassal.formuled.element.HotKey;
import com.bigb.vassal.formuled.element.enums.SystemProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;

/**
 * 
 */
@RequiredArgsConstructor
public class CounterDetailViewer extends BaseElement {
    
    @JacksonXmlProperty(isAttribute = true)
    private final int borderWidth = 0;
    
    @JacksonXmlProperty(isAttribute = true)
    private final String counterReportFormat = StringUtils.EMPTY;
    
    @JacksonXmlProperty(isAttribute = true)
    private final int delay = 700;
    
    @JacksonXmlProperty(isAttribute = true)
    private final String display = "from top-most layer only";

    @JacksonXmlProperty(isAttribute = true)
    private final SystemProperty emptyHexReportForma = SystemProperty.LOCATION;
    
    @JacksonXmlProperty(isAttribute = true)
    private final Color fgColor;
    
    @JacksonXmlProperty(isAttribute = true)
    private final int fontSize = 9;
    
    @JacksonXmlProperty(isAttribute = true)
    private final double graphicsZoom = 1.0;
    
    @JacksonXmlProperty(isAttribute = true)
    private final HotKey hotkey = HotKey.CTRL_SPACE;
    
    @JacksonXmlProperty(isAttribute = true)
    private final String layerList = StringUtils.EMPTY;
    
    @JacksonXmlProperty(isAttribute = true)
    private final int minDisplayPieces = 2;
    
    @JacksonXmlProperty(isAttribute = true)
    private final String propertyFilter = StringUtils.EMPTY;
    
    @JacksonXmlProperty(isAttribute = true)
    private final boolean showDeck = false;
    
    // Typo is name is normal...
    @JacksonXmlProperty(isAttribute = true)
    private final boolean showMoveSelectde = false;
    
    @JacksonXmlProperty(isAttribute = true)
    private final boolean showNoStack = false;
    
    @JacksonXmlProperty(isAttribute = true)
    private final boolean showNonMovable = false;
    
    @JacksonXmlProperty(isAttribute = true)
    private final boolean showgraph = true;
    
    @JacksonXmlProperty(isAttribute = true)
    private final boolean showgraphsingle = false;
    
    @JacksonXmlProperty(isAttribute = true)
    private final boolean showtext = false;
    
    @JacksonXmlProperty(isAttribute = true)
    private final boolean showtextsingle = false;
    
    @JacksonXmlProperty(isAttribute = true)
    private final SystemProperty summaryReportFormat = SystemProperty.LOCATION;
    
    @JacksonXmlProperty(isAttribute = true)
    private final boolean unrotatePieces = false;
    
    @JacksonXmlProperty(isAttribute = true)
    private final String version;
    
    @JacksonXmlProperty(isAttribute = true)
    private final double zoomlevel = 1.0;
}
