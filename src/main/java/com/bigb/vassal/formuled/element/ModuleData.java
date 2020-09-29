package com.bigb.vassal.formuled.element;

import com.bigb.vassal.formuled.configuration.Settings;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

/**
 * 
 */
@JacksonXmlRootElement(localName = "data")
public class ModuleData extends ConfigurableElement {
    
    @JacksonXmlProperty
    private final String version;

    @JacksonXmlProperty
    private final String VassalVersion;

    @JacksonXmlProperty
    private final long dateSaved;

    @JacksonXmlProperty
    private final String description;

    @JacksonXmlProperty
    private final String name = "Formula Dé";
    
    public ModuleData(Settings settings) {
        super(settings);
        this.version = settings.getModuleVersion();
        this.VassalVersion = settings.getVassalVersion();
        this.description= settings.getDescription();
        this.dateSaved = System.currentTimeMillis();
    }
}
