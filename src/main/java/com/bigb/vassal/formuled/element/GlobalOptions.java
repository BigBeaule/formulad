package com.bigb.vassal.formuled.element;

import com.bigb.vassal.formuled.element.enums.OptionState;
import com.bigb.vassal.formuled.element.enums.Variable;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;

import java.util.Arrays;
import java.util.List;
import lombok.RequiredArgsConstructor;

/**
 * 
 */
public class GlobalOptions extends BaseElement {
    public static final String NAME = MODULE + "GlobalOptions";

    @JacksonXmlProperty(isAttribute = true)
    private final OptionState autoReport = OptionState.ALWAYS;

//    Removed since Vassal 3.4.0
//    @JacksonXmlProperty(isAttribute = true)
//    private final OptionState centerOnMove = OptionState.NEVER;

    @JacksonXmlProperty(isAttribute = true)
    private final OptionState nonOwnerUnmaskable = OptionState.NEVER;

    @JacksonXmlProperty(isAttribute = true)
    private final Variable playerIdFormat = Variable.PLAYER;

    @JacksonXmlProperty(isAttribute = true)
    private final OptionState chatterHTMLSupport = OptionState.ALWAYS;

    @JacksonXmlProperty(isAttribute = true)
    private final String promptString = "Opponents can unmask my pieces";

    @JacksonXmlElementWrapper(useWrapping = false)
    private final List<Option> option = Arrays.asList(//
            new Option("stepIcon", "/images/StepForward16.gif"), //
            new Option("undoIcon", "/images/Undo16.gif"), //
            new Option("stepHotKey", HotKey.PAGE_DOWN), //
            new Option("serverControlsIcon", "/images/connect.gif"), //
            new Option("serverControlsHotKey", HotKey.ALT_S));

    @RequiredArgsConstructor
    private static final class Option {
        @JacksonXmlProperty(isAttribute = true)
        private final String name;

        @JacksonXmlText
        private final Object value;
    }
}
