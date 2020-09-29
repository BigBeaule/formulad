package com.bigb.vassal.formuled.element;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.RequiredArgsConstructor;

/**
 * 
 */
@RequiredArgsConstructor
public abstract class MenuElement {

    @JacksonXmlProperty(isAttribute = true)
    private final String title;
}
