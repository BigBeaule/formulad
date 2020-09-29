package com.bigb.vassal.formuled.element.prototype;

import com.bigb.vassal.formuled.element.BaseElement;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.util.ArrayList;
import java.util.List;

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
