package com.bigb.vassal.formuled.element.prototype;

import com.bigb.vassal.formuled.element.BaseElement;
import com.bigb.vassal.formuled.element.enums.Prototype;
import com.bigb.vassal.formuled.element.trait.Traits;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;

import lombok.RequiredArgsConstructor;

/**
 * 
 */
@RequiredArgsConstructor
class PrototypeDefinition extends BaseElement {
    @JacksonXmlProperty(isAttribute = true, localName = "name")
    private final Prototype id;

    @JacksonXmlText
    private final Traits traits;
}
