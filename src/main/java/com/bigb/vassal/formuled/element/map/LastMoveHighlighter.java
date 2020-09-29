package com.bigb.vassal.formuled.element.map;

import com.bigb.vassal.formuled.configuration.Color;
import com.bigb.vassal.formuled.element.BaseElement;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

/**
 * 
 */
public class LastMoveHighlighter extends BaseElement {
    @JacksonXmlProperty(isAttribute = true)
    private final Color color = new Color(255, 0, 0);

    @JacksonXmlProperty(isAttribute = true)
    private final boolean enabled = true;

    @JacksonXmlProperty(isAttribute = true)
    private final int thickness = 2;
}
