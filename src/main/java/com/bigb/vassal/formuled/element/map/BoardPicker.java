package com.bigb.vassal.formuled.element.map;

import com.bigb.vassal.formuled.element.MenuElement;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.util.Arrays;
import java.util.List;

/**
 * 
 */
public abstract class BoardPicker extends MenuElement {
    protected static final String BOARD_PICKER_PREFIX = BaseMap.MAP_PREFIX + "boardPicker.";
    protected static final String BOARD_PREFIX = BOARD_PICKER_PREFIX + "board.";

    @JacksonXmlProperty(isAttribute = true)
    private final String addColumnText = "Add column";

    @JacksonXmlProperty(isAttribute = true)
    private final String addRowText = "Add row";

    @JacksonXmlProperty(isAttribute = true)
    private final String boardPrompt;

    @JacksonXmlProperty(isAttribute = true)
    private final int slotHeight;

    @JacksonXmlProperty(isAttribute = true)
    private final double slotScale = 0.2;

    @JacksonXmlProperty(isAttribute = true)
    private final int slotWidth;

    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = BOARD_PICKER_PREFIX + "Board")
    private final List<Board> boards;

    public BoardPicker(String boardPrompt, int slotHeight, int slotWidth, String tooltip, Board... boards) {
        super(tooltip);
        this.boardPrompt = boardPrompt;
        this.slotHeight = slotHeight;
        this.slotWidth = slotWidth;
        this.boards = Arrays.asList(boards);
    }
}
