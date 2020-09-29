package com.bigb.vassal.formuled.element.dice;

import com.bigb.vassal.formuled.element.BaseElement;
import com.bigb.vassal.formuled.element.HotKey;
import com.bigb.vassal.formuled.element.enums.Variable;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * 
 */
@RequiredArgsConstructor
public class SpecialDiceButton extends BaseElement {
    public static final String NAME = MODULE + "SpecialDiceButton";
    
    @JacksonXmlProperty(isAttribute = true)
    private final @NonNull String format;

    @JacksonXmlProperty(isAttribute = true)
    private final @NonNull HotKey hotkey;

    @JacksonXmlProperty(isAttribute = true)
    private final @NonNull String icon;

    @JacksonXmlProperty(isAttribute = true)
    private final @NonNull String name;

    @JacksonXmlProperty(isAttribute = true)
    private final boolean resultButton;

    @JacksonXmlProperty(isAttribute = true)
    private final boolean resultChatter;

    @JacksonXmlProperty(isAttribute = true)
    private final boolean resultWindow;

    @JacksonXmlProperty(isAttribute = true)
    private final @NonNull String text;

    @JacksonXmlProperty(isAttribute = true)
    private final @NonNull String tooltip;

    @JacksonXmlProperty(isAttribute = true)
    private final @NonNull Variable windowTitleResultFormat;

    @JacksonXmlProperty(isAttribute = true)
    private final int windowX;

    @JacksonXmlProperty(isAttribute = true)
    private final int windowY;

    @JacksonXmlProperty(localName = SpecialDie.NAME)
    private final @NonNull SpecialDie die;
}
