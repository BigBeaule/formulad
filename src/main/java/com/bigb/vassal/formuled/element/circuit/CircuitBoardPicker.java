package com.bigb.vassal.formuled.element.circuit;

import com.bigb.vassal.formuled.element.BaseElement;
import com.bigb.vassal.formuled.element.EmptyElement;
import com.bigb.vassal.formuled.element.enums.Variable;
import com.bigb.vassal.formuled.element.map.Board;
import com.bigb.vassal.formuled.element.map.BoardPicker;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import org.apache.commons.lang3.StringUtils;

/**
 * 
 */
public class CircuitBoardPicker extends BoardPicker {
    public CircuitBoardPicker() {
        super("Choose circuit", 125, 350, "Choose circuit", new CircuitBoard("Hockenheim_3.jpg", "Hockenheim", false),
                new CircuitBoard("Jacarepagua_3.jpg", "Jacarepaguà", false));
    }

    private static final class CircuitBoard extends Board {
        @JacksonXmlProperty(localName = BOARD_PREFIX + "ZonedGrid")
        private final ZonedGrid zonedGrid = new ZonedGrid();

        public CircuitBoard(String image, String name, boolean reversible) {
            super(image, name, reversible);
        }
    }

    private static final class ZonedGrid extends BaseElement {
        @JacksonXmlProperty(localName = BOARD_PREFIX + "mapgrid.ZonedGridHighlighter")
        private final EmptyElement gridHighlighter = EmptyElement.ELEMENT;

        @JacksonXmlProperty(localName = BOARD_PREFIX + "mapgrid.Zone")
        private final Zone zone = new Zone();
    }

    private static final class Zone extends BaseElement {
        @JacksonXmlProperty(isAttribute = true)
        private final String highlightProperty = StringUtils.EMPTY;

        @JacksonXmlProperty(isAttribute = true)
        private final Variable locationFormat = Variable.NAME;

        @JacksonXmlProperty(isAttribute = true)
        private final String name = "Circuit";

        @JacksonXmlProperty(isAttribute = true)
        private final String path = "0,0;25000,0;25000,25000;0,25000";

        @JacksonXmlProperty(isAttribute = true)
        private final boolean useHighlight = false;

        @JacksonXmlProperty(isAttribute = true)
        private final boolean useParentGrid = false;
    }
}
