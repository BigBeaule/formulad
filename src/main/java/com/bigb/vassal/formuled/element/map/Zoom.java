package com.bigb.vassal.formuled.element.map;

import com.bigb.vassal.formuled.element.BaseElement;
import com.bigb.vassal.formuled.element.HotKey;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;

/**
 * 
 */
@RequiredArgsConstructor
public class Zoom extends BaseElement {
    @JacksonXmlProperty(isAttribute = true)
    private final String inButtonText = StringUtils.EMPTY;

    @JacksonXmlProperty(isAttribute = true)
    private final String inIconName;

    @JacksonXmlProperty(isAttribute = true)
    private final String inTooltip;

    @JacksonXmlProperty(isAttribute = true)
    private final String outButtonText = StringUtils.EMPTY;

    @JacksonXmlProperty(isAttribute = true)
    private final String outIconName;

    @JacksonXmlProperty(isAttribute = true)
    private final String outTooltip;

    @JacksonXmlProperty(isAttribute = true)
    private final String pickButtonText = StringUtils.EMPTY;

    @JacksonXmlProperty(isAttribute = true)
    private final String pickIconName;

    @JacksonXmlProperty(isAttribute = true)
    private final String pickTooltip = "Select Zoom";

    @JacksonXmlProperty(isAttribute = true)
    private final HotKey zoomInKey = HotKey.NONE;

    @JacksonXmlProperty(isAttribute = true)
    private final HotKey zoomOutKey = HotKey.NONE;

    @JacksonXmlProperty(isAttribute = true)
    private final HotKey zoomPickKey = HotKey.NONE;

    @JacksonXmlProperty(isAttribute = true)
    private final String zoomLevels;

    @JacksonXmlProperty(isAttribute = true)
    private final int zoomStart;
}
