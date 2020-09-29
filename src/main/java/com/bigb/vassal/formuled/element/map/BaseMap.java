package com.bigb.vassal.formuled.element.map;

import com.bigb.vassal.formuled.configuration.Color;
import com.bigb.vassal.formuled.element.BaseElement;
import com.bigb.vassal.formuled.element.EmptyElement;
import com.bigb.vassal.formuled.element.HotKey;
import com.bigb.vassal.formuled.element.enums.OptionState;
import com.bigb.vassal.formuled.element.enums.Variable;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;

/**
 * 
 */
@RequiredArgsConstructor
public abstract class BaseMap extends BaseElement {
    public static final String MAP_PREFIX = MODULE + "map.";
    
    // ------------------------------------- Attributes -------------------------------------
    @JacksonXmlProperty(isAttribute = true)
    private final boolean allowMultiple = true;

    @JacksonXmlProperty(isAttribute = true)
    private final Color backgroundcolor = Color.WHITE;

    @JacksonXmlProperty(isAttribute = true)
    private final String buttonName;

    @JacksonXmlProperty(isAttribute = true)
    private final Variable changeFormat = Variable.MESSAGE;

    @JacksonXmlProperty(isAttribute = true)
    private final Color color;

    @JacksonXmlProperty(isAttribute = true)
    private final String createFormat;

    @JacksonXmlProperty(isAttribute = true)
    private final int edgeHeight = 0;

    @JacksonXmlProperty(isAttribute = true)
    private final int edgeWidth = 0;

    @JacksonXmlProperty(isAttribute = true)
    private final HotKey hotkey;

    @JacksonXmlProperty(isAttribute = true)
    private final String icon;

    @JacksonXmlProperty(isAttribute = true)
    private final boolean launch;

    @JacksonXmlProperty(isAttribute = true)
    private final String mapName;

    @JacksonXmlProperty(isAttribute = true)
    private final OptionState markMoved;

    @JacksonXmlProperty(isAttribute = true)
    private final String markUnmovedIcon;

    @JacksonXmlProperty(isAttribute = true)
    private final String markUnmovedText = StringUtils.EMPTY;

    @JacksonXmlProperty(isAttribute = true)
    private final String markUnmovedTooltip;

    @JacksonXmlProperty(isAttribute = true)
    private final HotKey moveKey = HotKey.NONE;

    @JacksonXmlProperty(isAttribute = true)
    private final String moveToFormat = StringUtils.EMPTY;

    @JacksonXmlProperty(isAttribute = true)
    private final String moveWithinFormat;

    @JacksonXmlProperty(isAttribute = true)
    private final int thickness = 3;

    // ------------------------------------- Elements -------------------------------------
    @JacksonXmlProperty(localName = MAP_PREFIX + "ForwardToKeyBuffer")
    private final EmptyElement forwardToKeyBuffer = EmptyElement.ELEMENT;

    @JacksonXmlProperty(localName = MAP_PREFIX + "Scroller")
    private final EmptyElement scroller = EmptyElement.ELEMENT;

    @JacksonXmlProperty(localName = MAP_PREFIX + "ForwardToChatter")
    private final EmptyElement forwardToChatter = EmptyElement.ELEMENT;

    @JacksonXmlProperty(localName = MAP_PREFIX + "MenuDisplayer")
    private final EmptyElement menuDisplayer = EmptyElement.ELEMENT;

    @JacksonXmlProperty(localName = MAP_PREFIX + "MapCenterer")
    private final EmptyElement mapCenterer = EmptyElement.ELEMENT;

    @JacksonXmlProperty(localName = MAP_PREFIX + "StackExpander")
    private final EmptyElement stackExpander = EmptyElement.ELEMENT;

    @JacksonXmlProperty(localName = MAP_PREFIX + "PieceMover")
    private final EmptyElement pieceMover = EmptyElement.ELEMENT;

    @JacksonXmlProperty(localName = MAP_PREFIX + "KeyBufferer")
    private final EmptyElement keyBufferer = EmptyElement.ELEMENT;

    @JacksonXmlProperty(localName = MAP_PREFIX + "BoardPicker")
    private final BoardPicker boardPicker;

    @JacksonXmlProperty(localName = MAP_PREFIX + "StackMetrics")
    private final StackMetrics stackMetrics = new StackMetrics();

    @JacksonXmlProperty(localName = MAP_PREFIX + "ImageSaver")
    private final ImageSaver imageSaver;

    @JacksonXmlProperty(localName = MAP_PREFIX + "CounterDetailViewer")
    private final CounterDetailViewer viewer;

    @JacksonXmlProperty(localName = MODULE + "properties.GlobalProperties")
    private final EmptyElement globalProps = EmptyElement.ELEMENT;

    @JacksonXmlProperty(localName = MAP_PREFIX + "SelectionHighlighters")
    private final EmptyElement selectionHighlighters = EmptyElement.ELEMENT;

    @JacksonXmlProperty(localName = MAP_PREFIX + "HighlightLastMoved")
    private final LastMoveHighlighter lastMoveHighlighter = new LastMoveHighlighter();

    @JacksonXmlProperty(localName = MAP_PREFIX + "Zoomer")
    private final Zoom zoom;
}
