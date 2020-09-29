package com.bigb.vassal.formuled.element.map;

import com.bigb.vassal.formuled.element.BaseElement;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import lombok.RequiredArgsConstructor;

/**
 * 
 */
@RequiredArgsConstructor
public class Board extends BaseElement {
    @JacksonXmlProperty(isAttribute = true)
    private final String image;

    @JacksonXmlProperty(isAttribute = true)
    private final String name;

    @JacksonXmlProperty(isAttribute = true)
    private final boolean reversible;
}
