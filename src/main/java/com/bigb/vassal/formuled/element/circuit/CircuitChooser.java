package com.bigb.vassal.formuled.element.circuit;

import com.bigb.vassal.formuled.configuration.Color;
import com.bigb.vassal.formuled.element.HotKey;
import com.bigb.vassal.formuled.element.enums.OptionState;
import com.bigb.vassal.formuled.element.enums.SystemProperty;
import com.bigb.vassal.formuled.element.enums.Variable;
import com.bigb.vassal.formuled.element.map.BaseMap;
import com.bigb.vassal.formuled.element.map.CounterDetailViewer;
import com.bigb.vassal.formuled.element.map.GlobalMap;
import com.bigb.vassal.formuled.element.map.ImageSaver;
import com.bigb.vassal.formuled.element.map.LayeredPiece;
import com.bigb.vassal.formuled.element.map.Zoom;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import org.apache.commons.lang3.StringUtils;

/**
 * 
 */
public class CircuitChooser extends BaseMap {
    public static final String NAME = MODULE + "Map";

    @JacksonXmlProperty(localName = MAP_PREFIX + "LayeredPieceCollection")
    private final LayeredPiece layeredPiece = new LayeredPiece();

    @JacksonXmlProperty(localName = MAP_PREFIX + "GlobalMap")
    private final GlobalMap globalMap = new GlobalMap();

    public CircuitChooser() {
        super("Circuit", new Color(0, 204, 51), "<" + Variable.PLAYER + "> creates " + SystemProperty.MAP_PIECE,
                HotKey.CTRL_SHIFT_T, StringUtils.EMPTY, false, CIRCUIT_MAP, OptionState.ALWAYS, "eraser.png",
                "Marks all pieces unmoved", "<" + Variable.PLAYER + "> moves " + SystemProperty.MAP_PIECE,
                new CircuitBoardPicker(), new ImageSaver("Macchina_fotografica.png"),
                new CounterDetailViewer(new Color(0, 204, 51), "2"), new Zoom(StringUtils.EMPTY, StringUtils.EMPTY,
                        StringUtils.EMPTY, StringUtils.EMPTY, "Binocolo.png", "0.5,0.666,0.75,0.833,1.0,1.25,1.5", 5));
    }
}
