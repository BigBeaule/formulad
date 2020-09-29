package com.bigb.vassal.formuled.element.map;

import com.bigb.vassal.formuled.element.BaseElement;
import com.bigb.vassal.formuled.element.enums.GamePiece;
import com.bigb.vassal.formuled.element.enums.Variable;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 
 */
public class LayeredPiece extends BaseElement {
    @JacksonXmlProperty(isAttribute = true)
    private final String property = Variable.LAYER.getVarName();

    @JacksonXmlProperty(isAttribute = true)
    public String getLayerOrder() {
        return Stream.of(GamePiece.values()).sorted((a, b) -> Integer.compare(a.getZIndex(), b.getZIndex()))
                .map(GamePiece::getName).collect(Collectors.joining(","));
    }
}
