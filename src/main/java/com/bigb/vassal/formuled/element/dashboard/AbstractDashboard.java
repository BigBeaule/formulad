package com.bigb.vassal.formuled.element.dashboard;

import com.bigb.vassal.formuled.configuration.Color;
import com.bigb.vassal.formuled.configuration.Team;
import com.bigb.vassal.formuled.element.GlobalProperties;
import com.bigb.vassal.formuled.element.HotKey;
import com.bigb.vassal.formuled.element.GlobalProperties.GlobalProperty;
import com.bigb.vassal.formuled.element.circuit.SetupStack;
import com.bigb.vassal.formuled.element.enums.CarResource;
import com.bigb.vassal.formuled.element.enums.Font;
import com.bigb.vassal.formuled.element.enums.NoStackType;
import com.bigb.vassal.formuled.element.enums.OptionState;
import com.bigb.vassal.formuled.element.enums.Position;
import com.bigb.vassal.formuled.element.enums.Prototype;
import com.bigb.vassal.formuled.element.enums.SystemProperty;
import com.bigb.vassal.formuled.element.enums.Tire;
import com.bigb.vassal.formuled.element.enums.Variable;
import com.bigb.vassal.formuled.element.map.BaseMap;
import com.bigb.vassal.formuled.element.map.CounterDetailViewer;
import com.bigb.vassal.formuled.element.map.ImageSaver;
import com.bigb.vassal.formuled.element.map.Zoom;
import com.bigb.vassal.formuled.element.piece.PieceSlot;
import com.bigb.vassal.formuled.element.trait.Label;
import com.bigb.vassal.formuled.element.trait.Marker;
import com.bigb.vassal.formuled.element.trait.NoStack;
import com.bigb.vassal.formuled.element.trait.PrototypeRef;
import com.bigb.vassal.formuled.element.trait.Traits;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

import org.apache.commons.lang3.StringUtils;

/**
 * 
 */
public abstract class AbstractDashboard extends BaseMap {
    public static final String NAME = MODULE + "PrivateMap";

    // ------------------------------------- Attributes -------------------------------------
    @JacksonXmlProperty(isAttribute = true)
    private final String side;

    @JacksonXmlProperty(isAttribute = true)
    private final String tooltip;

    @JacksonXmlProperty(isAttribute = true)
    private final boolean visible = true;

    // ------------------------------------- Elements -------------------------------------
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = SetupStack.NAME)
    protected final List<SetupStack> widgets = new ArrayList<>();

    /**
     * 
     */
    public AbstractDashboard(String name, String icon, String players, Team team, int carNumber, int defaultZoom,
            Function<CarResource, Integer> globalPropsMaxValueRetriever) {

        super(StringUtils.EMPTY, new Color(0, 255, 204), StringUtils.EMPTY, HotKey.NONE, icon, true, name,
                OptionState.NEVER, "/images/unmoved.gif", StringUtils.EMPTY, StringUtils.EMPTY,
                new DashBoardPicker(team, carNumber), new ImageSaver("/images/camera.gif"),
                new CounterDetailViewer(Color.BLACK, StringUtils.EMPTY),
                getGlobalProperties(globalPropsMaxValueRetriever), new Zoom("/images/zoomIn.gif", "Zoom in",
                        "/images/zoomOut.gif", "Zoom out", "/images/zoom.png", "0.390625,0.625,1.0,1.6", defaultZoom));

        this.tooltip = name;
        this.side = players;
    }

    private static GlobalProperties getGlobalProperties(Function<CarResource, Integer> maxValueRetriever) {
        List<GlobalProperty> props = new ArrayList<>();
        Stream.of(CarResource.ENGINE, CarResource.BODY, CarResource.HOLDING).forEach(r -> {
            int max = maxValueRetriever.apply(r);
            props.add(new GlobalProperty("used" + r.getType(), 0, max, 0, false));
            props.add(new GlobalProperty("setup" + r.getType(), 0, max, max, false));
        });
        props.add(new GlobalProperty(Variable.CURRENT_GEAR.getVarName(), 0, 6, 0, false));
        props.add(new GlobalProperty(Variable.CURRENT_STOPS.getVarName(), 0, 4, 0, false));

        props.sort((p1, p2) -> StringUtils.compare(p1.getName(), p2.getName()));
        return new GlobalProperties(props);
    }

    protected final SetupStack getPosition(int x, int y) {
        String name = "Position";
        Traits traits = new Traits(getNextId(), "unused.png", name);
        traits.addTrait(new Label(name, "1", SystemProperty.MAP_PIECE + " (" + Variable.LABEL + ")", name,
                "Change Position", HotKey.ENTER, Font.DIALOG, 24, false, false, null, Color.BLACK, Position.BOTTOM,
                Position.BOTTOM, -6, Position.CENTER, Position.CENTER, -3, 0));

        traits.addTrait(new NoStack(NoStackType.NORMALLY_NORMALLY_NEVER));
        return new SetupStack(name, x, y, new PieceSlot(name, 0, 0, traits));
    }

    protected final SetupStack getLapButton(int lap, int x, int y) {
        String name = "Lap " + lap;
        Traits traits = new Traits(getNextId(), null, name);
        traits.addTrait(new PrototypeRef(Prototype.DASH_BOX));
        return new SetupStack("Lap" + lap, x, y, new PieceSlot(name, 0, 0, traits));
    }

    protected final SetupStack getPitStop(int lap, int x, int y) {
        String name = "Pitstop Lap " + lap;
        Traits traits = new Traits(getNextId(), null, name);
        traits.addTrait(new PrototypeRef(Prototype.DASH_BOX));
        return new SetupStack("Pitstop" + lap, x, y, new PieceSlot(name, 0, 0, traits));
    }

    protected final SetupStack getSelectedTire(Tire tire, int lap, int x, int y) {
        String name = tire.getType() + " Lap " + lap;
        Traits traits = new Traits(getNextId(), null, name);
        traits.addTrait(new PrototypeRef(Prototype.DASH_BOX));
        return new SetupStack(tire.getType() + lap, x, y, new PieceSlot(name, 0, 0, traits));
    }

    protected final SetupStack getGearPanel(Team team, int carNumber, int x, int y) {
        Traits traits = new Traits(getNextId(), null, null);
        traits.addTrait(new Marker(Variable.CAR.getVarName(), team.getId() + " " + carNumber));
        traits.addTrait(new PrototypeRef(Prototype.DASH_GEARS));
        return new SetupStack("Gears", x, y, new PieceSlot(StringUtils.EMPTY, 0, 0, traits));
    }

    protected final SetupStack getCarResourceSetup(Prototype prototype, CarResource resource, Team team, int carNumber,
            int x, int y) {

        String name = "Setup " + resource;
        Traits traits = new Traits(getNextId(), "unused.png", name);
        traits.addTrait(new Marker(Variable.CAR.getVarName(), team.getId() + " " + carNumber));
        traits.addTrait(new Marker(Variable.BOX.getVarName(), resource.getType()));
        traits.addTrait(new PrototypeRef(prototype));
        return new SetupStack("Setup" + resource, x, y, new PieceSlot(name, 0, 0, traits));
    }

    protected final SetupStack getCarResource(Prototype boxPrototype, CarResource resource, Team team, int carNumber,
            int index, int x, int y) {
        String name = resource + " " + index;
        Traits traits = new Traits(getNextId(), null, name);
        traits.addTrait(new Marker(Variable.INDEX.getVarName(), index));
        traits.addTrait(new Marker(Variable.BOX.getVarName(), resource.getType()));
        traits.addTrait(new Marker(Variable.CAR.getVarName(), team.getId() + " " + carNumber));
        traits.addTrait(new PrototypeRef(boxPrototype));
        return new SetupStack(resource.getType() + index, x, y, new PieceSlot(name, 0, 0, traits));
    }

    protected final SetupStack getRepair(int index, int x, int y) {
        String name = "Repair " + index;
        Traits traits = new Traits(getNextId(), null, name);
        traits.addTrait(new PrototypeRef(Prototype.DASH_BOX));
        return new SetupStack("Repair" + index, x, y, new PieceSlot(name, 0, 0, traits));
    }

    protected final SetupStack getInputBox(Variable variable, String defaultText, int x, int y) {
        String name = variable.getVarName();
        Traits traits = new Traits(getNextId(), "emptylabel.png", null);
        traits.addTrait(new Label(name, defaultText, SystemProperty.MAP_PIECE + " (" + Variable.LABEL + ")", name,
                "Change Name", HotKey.ENTER, Font.DIALOG, 24, false, false, null, Color.BLACK, Position.BOTTOM,
                Position.BOTTOM, -5, Position.LEFT, Position.LEFT, 0, 0));

        traits.addTrait(new NoStack(NoStackType.NORMALLY_NORMALLY_NEVER));
        return new SetupStack(name, x, y, new PieceSlot(StringUtils.EMPTY, 0, 0, traits));
    }
}
