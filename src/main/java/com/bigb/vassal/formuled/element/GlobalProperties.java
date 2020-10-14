package com.bigb.vassal.formuled.element;

import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class GlobalProperties extends BaseElement {
    public static final String NAME = MODULE + "properties.GlobalProperties";
    
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = GlobalProperty.NAME)
    private final List<GlobalProperty> properties;
    
    public GlobalProperties(GlobalProperty... props) {
        this.properties = Arrays.asList(props);
    }

    @RequiredArgsConstructor
    public static final class GlobalProperty extends BaseElement{
        public static final String NAME = MODULE + "properties.GlobalProperty";
        
        @JacksonXmlProperty(isAttribute = true)
        private final @Getter String name;
        
        @JacksonXmlProperty(isAttribute = true)
        private final int min;
        
        @JacksonXmlProperty(isAttribute = true)
        private final int max;
        
        @JacksonXmlProperty(isAttribute = true)
        private final int initialValue;
        
        @JacksonXmlProperty(isAttribute = true)
        private final boolean wrap;
        
        @JacksonXmlProperty(isAttribute = true)
        private final boolean isNumeric = true;
    }
}
