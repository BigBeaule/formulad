package com.bigb.vassal.formuled.element;

import com.bigb.vassal.formuled.element.enums.Variable;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.util.Arrays;

import org.apache.commons.lang3.StringUtils;

/**
 * 
 */
public class TurnTracker extends BaseElement {
    public static final String NAME = MODULE + "turn.TurnTracker";

    @JacksonXmlProperty(isAttribute = true)
    private final String buttonText = StringUtils.EMPTY;

    @JacksonXmlProperty(isAttribute = true)
    private final String buttonTooltip = "Sunshine";

    @JacksonXmlProperty(isAttribute = true)
    private final HotKey hotKey = HotKey.NONE;

    @JacksonXmlProperty(isAttribute = true)
    private final String icon = "weather.png";

    @JacksonXmlProperty(isAttribute = true)
    private final int length = -1;

    @JacksonXmlProperty(isAttribute = true)
    private final String lengthStyle = "Maximum";

    @JacksonXmlProperty(isAttribute = true)
    private final String name = "Weather";

    @JacksonXmlProperty(isAttribute = true)
    private final HotKey nexthotkey = HotKey.NONE;

    @JacksonXmlProperty(isAttribute = true)
    private final HotKey prevhotkey = HotKey.NONE;

    @JacksonXmlProperty(isAttribute = true)
    private final String reportFormat = "<b>" + Variable.PLAYER_ID + "</b> weather Updated from "
            + Variable.TURN.getOldVar() + " to " + Variable.TURN.getNewVar();

    @JacksonXmlProperty(isAttribute = true)
    private final String tooltip = "Weather";

    @JacksonXmlProperty(isAttribute = true)
    private final String turnFormat = "$level1$ $level2$ $level3$ $level4$";

    @JacksonXmlProperty(localName = MODULE + "turn.ListTurnLevel")
    private final ListTurnLevel turnList = new ListTurnLevel();

    private static final class ListTurnLevel extends BaseElement {
        @JacksonXmlProperty(isAttribute = true)
        private final boolean configFirst = false;

        @JacksonXmlProperty(isAttribute = true)
        private final boolean configList = false;

        @JacksonXmlProperty(isAttribute = true)
        private final String list = StringUtils.join(
                Arrays.asList(Variable.SUNNY.getVarName(), Variable.CLOUDY.getVarName(), Variable.RAINY.getVarName()),
                ',');

        @JacksonXmlProperty(isAttribute = true)
        private final String name = "Weather";

        @JacksonXmlProperty(isAttribute = true)
        private final String property = Variable.WEATHER.getVarName();

        @JacksonXmlProperty(isAttribute = true)
        private final String turnFormat = "$value$";
    }
}
