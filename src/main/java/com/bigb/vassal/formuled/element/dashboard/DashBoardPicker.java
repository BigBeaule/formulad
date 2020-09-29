package com.bigb.vassal.formuled.element.dashboard;

import com.bigb.vassal.formuled.configuration.Team;
import com.bigb.vassal.formuled.element.TextElement;
import com.bigb.vassal.formuled.element.map.Board;
import com.bigb.vassal.formuled.element.map.BoardPicker;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

/**
 * 
 */
public class DashBoardPicker extends BoardPicker {
    @JacksonXmlProperty()
    private final TextElement setup;

    public DashBoardPicker(Team team, int carNumber) {
        super("Select boards", 0, 0, "Select Map",
                new Board(team.getDashboardImage(), getDashId(team, carNumber), false));

        setup = new TextElement(
                team.getId() + " " + carNumber + "BoardPicker\t" + getDashId(team, carNumber) + "\t0\t0");
    }

    private static String getDashId(Team team, int carNumber) {
        return "Dash" + team.getId() + carNumber;
    }
}
