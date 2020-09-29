package com.bigb.vassal.formuled.element.map;

import com.bigb.vassal.formuled.configuration.Color;
import com.bigb.vassal.formuled.element.BaseElement;
import com.bigb.vassal.formuled.element.HotKey;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

/**
 * 
 */
public class GlobalMap extends BaseElement {
    @JacksonXmlProperty(isAttribute = true)
    private final String buttonText = "";

    @JacksonXmlProperty(isAttribute = true)
    private final Color color = new Color(0, 0, 0);

    @JacksonXmlProperty(isAttribute = true)
    private final HotKey hotkey = HotKey.CTRL_SHIFT_O;

    @JacksonXmlProperty(isAttribute = true)
    private final String icon = "overview.png";

    @JacksonXmlProperty(isAttribute = true)
    private final double scale = 0.15;

    @JacksonXmlProperty(isAttribute = true)
    private final String tooltip = "Show/Hide overview window";
}
