package com.bigb.vassal.formuled.element.dice;

import com.bigb.vassal.formuled.element.BaseElement;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import lombok.RequiredArgsConstructor;

/**
 * 
 */
@RequiredArgsConstructor
public class SpecialDieFace extends BaseElement {
    public static final String NAME = MODULE + "SpecialDieFace";
    
    @JacksonXmlProperty(isAttribute = true)
    private final String icon;
    
    @JacksonXmlProperty(isAttribute = true)
    private final String text;
    
    @JacksonXmlProperty(isAttribute = true)
    private final String value;
}
