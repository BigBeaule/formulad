package com.bigb.vassal.formuled.element;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;
import lombok.RequiredArgsConstructor;

/**
 * 
 */
@RequiredArgsConstructor
public class TextElement extends BaseElement {
    @JacksonXmlText
    private final String text;
}
