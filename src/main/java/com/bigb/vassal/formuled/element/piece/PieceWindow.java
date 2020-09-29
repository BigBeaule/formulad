package com.bigb.vassal.formuled.element.piece;

import com.bigb.vassal.formuled.configuration.Settings;
import com.bigb.vassal.formuled.configuration.Team;
import com.bigb.vassal.formuled.element.ConfigurableElement;
import com.bigb.vassal.formuled.element.HotKey;
import com.bigb.vassal.formuled.element.enums.Prototype;
import com.bigb.vassal.formuled.element.enums.Variable;
import com.bigb.vassal.formuled.element.trait.Marker;
import com.bigb.vassal.formuled.element.trait.MovementTrail;
import com.bigb.vassal.formuled.element.trait.PrototypeRef;
import com.bigb.vassal.formuled.element.trait.Traits;
import com.bigb.vassal.formuled.element.trait.Layer.LayerBuilder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;

/**
 * 
 */
public class PieceWindow extends ConfigurableElement {
    public static final String NAME = MODULE + "PieceWindow";

    @JacksonXmlProperty(isAttribute = true)
    private final boolean hidden = false;

    @JacksonXmlProperty(isAttribute = true)
    private final HotKey hotkey = HotKey.NONE;

    @JacksonXmlProperty(isAttribute = true)
    private final String icon = "Vetture.png";

    @JacksonXmlProperty(isAttribute = true)
    private final String text = StringUtils.EMPTY;

    @JacksonXmlProperty(isAttribute = true)
    private final String name = "Game pieces";

    @JacksonXmlProperty(isAttribute = true)
    private final String tooltip = "Game pieces";

    @JacksonXmlProperty(localName = WIDGET + "TabWidget")
    private final Tab tab;

    public PieceWindow(Settings settings) {
        super(settings);

        List<PieceSlot> carPieces = new ArrayList<>(settings.getTeams().size() * 2);
        settings.getTeams().forEach(team -> {
            carPieces.add(getCar(team, 1));
            carPieces.add(getCar(team, 2));
        });

        List<PieceSlot> markers = new ArrayList<>(5);
        markers.add(getMarker("Oil Marker", 77, 31, "chiazza_olio.png"));
        markers.add(getMarker("Marker", 43, 40, "segnalino.png"));
        markers.add(getMarker("Small Marker", 38, 36, "segnalino_p.png"));
        markers.add(getMarker("Directional Marker", 43, 40, "segnalino_d.png"));
        markers.add(getMarker("Directional Marker", 43, 40, "segnalino_s.png"));

        this.tab = new Tab(Arrays.asList( //
                new Panel("Cars", carPieces.size(), true, false, carPieces), //
                new Panel("Markers", 3, false, false, markers)));
    }

    @RequiredArgsConstructor
    private static final class Tab {
        @JacksonXmlElementWrapper(useWrapping = false)
        @JacksonXmlProperty(localName = WIDGET + "PanelWidget")
        private final List<Panel> panels;
    }

    private PieceSlot getCar(Team team, int carNumber) {
        String carName = team.getId() + " " + carNumber;
        Traits traits = new Traits(getNextId(), team.getCarAsset(), carName);
        traits.addTrait(new Marker(Variable.CAR.getVarName(), carName));
        traits.addTrait(new MovementTrail(team.getTrailStop(), team.getTrailLine()));
        traits.addTrait(new PrototypeRef(carNumber == 1 ? Prototype.CAR_1 : Prototype.CAR_2));
        traits.addTrait(new LayerBuilder(null).activateLayer("Highlight", HotKey.CTRL_B).addLevel(team.getCarAsset())
                .build(-1));

        return new PieceSlot(carName, 77, 31, traits);
    }

    private PieceSlot getMarker(String name, int height, int width, String image) {
        Traits traits = new Traits(getNextId(), image, name);
        traits.addTrait(new PrototypeRef(Prototype.MARKER));
        return new PieceSlot(name, height, width, traits);
    }
}
