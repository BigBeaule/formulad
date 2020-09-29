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
public class ImageSaver extends BaseElement {
    @JacksonXmlProperty(isAttribute = true)
    private final String buttonText = StringUtils.EMPTY;

    @JacksonXmlProperty(isAttribute = true)
    private final HotKey hotkey = HotKey.NONE;

    @JacksonXmlProperty(isAttribute = true)
    private final String icon;

    @JacksonXmlProperty(isAttribute = true)
    private final String tooltip = "Save Map as PNG image";
}
