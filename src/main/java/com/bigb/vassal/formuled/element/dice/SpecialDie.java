package com.bigb.vassal.formuled.element.dice;

import com.bigb.vassal.formuled.element.BaseElement;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.util.List;
import lombok.RequiredArgsConstructor;

/**
 * 
 */
@RequiredArgsConstructor
public class SpecialDie extends BaseElement {
    public static final String NAME = MODULE + "SpecialDie";

    @JacksonXmlProperty(isAttribute = true)
    private final String format;

    @JacksonXmlProperty(isAttribute = true)
    private final String name;

    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = SpecialDieFace.NAME)
    private final List<SpecialDieFace> faces;
}
