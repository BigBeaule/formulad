package com.bigb.vassal.formuled.element;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

/**
 * 
 */
public class PlayerRoster extends BaseElement {
    public static final String NAME = MODULE + "PlayerRoster";

    @JacksonXmlProperty(isAttribute = true)
    private final String buttonIcon = "Exit.png";

    @JacksonXmlProperty(isAttribute = true)
    private final String buttonText = StringUtils.EMPTY;

    @JacksonXmlProperty(isAttribute = true)
    private final String buttonToolTip = "Retire";

    @JacksonXmlElementWrapper(useWrapping = false)
    private final @Getter List<String> entry;

    public PlayerRoster(int playerCount) {
        this.entry = IntStream.range(0, playerCount).mapToObj(i -> "Player " + (i + 1)).collect(Collectors.toList());
    }
}
