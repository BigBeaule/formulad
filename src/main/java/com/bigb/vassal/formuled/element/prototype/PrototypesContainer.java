package com.bigb.vassal.formuled.element.prototype;

import java.util.ArrayList;
import java.util.List;

import com.bigb.vassal.formuled.element.BaseElement;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

/**
 * 
 */
public abstract class PrototypesContainer extends BaseElement {
    public static final String NAME = MODULE + "PrototypesContainer";

    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = MODULE + "PrototypeDefinition")
    private final List<PrototypeDefinition> prototypes;

    /**
     * 
     */
    public PrototypesContainer(int size) {
        this.prototypes = new ArrayList<>(size);
    }

    protected void addPrototype(PrototypeDefinition prototype) {
        this.prototypes.add(prototype);
    }
}
