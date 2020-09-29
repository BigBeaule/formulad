package com.bigb.vassal.formuled.element;

import com.bigb.vassal.formuled.configuration.Settings;
import com.bigb.vassal.formuled.element.circuit.CircuitChooser;
import com.bigb.vassal.formuled.element.dashboard.AbstractDashboard;
import com.bigb.vassal.formuled.element.dashboard.DashboardV1;
import com.bigb.vassal.formuled.element.dashboard.DashboardV2;
import com.bigb.vassal.formuled.element.dice.SpecialDiceButton;
import com.bigb.vassal.formuled.element.dice.SpecialDie;
import com.bigb.vassal.formuled.element.dice.SpecialDieFace;
import com.bigb.vassal.formuled.element.enums.Variable;
import com.bigb.vassal.formuled.element.piece.PieceWindow;
import com.bigb.vassal.formuled.element.prototype.PrototypesContainer;
import com.bigb.vassal.formuled.element.prototype.PrototypesContainerV1;
import com.bigb.vassal.formuled.element.prototype.PrototypesContainerV2;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import static com.bigb.vassal.formuled.element.BaseElement.VASSAL;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.apache.commons.lang3.StringUtils;

/**
 * 
 */
@JacksonXmlRootElement(localName = VASSAL + "launch.BasicModule")
public class ModuleBuild extends ConfigurableElement {
    // ------------------------------------- Attributes -------------------------------------
    @JacksonXmlProperty(isAttribute = true, localName = "VassalVersion")
    private final String vassalVersion;

    @JacksonXmlProperty(isAttribute = true)
    private final String description;

    @JacksonXmlProperty(isAttribute = true)
    private final String name = "Formula Dé";

    @JacksonXmlProperty(isAttribute = true, localName = "version")
    private final String moduleVersion;

    @JacksonXmlProperty(isAttribute = true, localName = "nextPieceSlotId")
    public int getNextPieceSlotId() {
        return super.getNextId();
    }

    // ------------------------------------- Elements -------------------------------------
    @JacksonXmlProperty(localName = MODULE + "BasicCommandEncoder")
    private final EmptyElement commandEncoder = EmptyElement.ELEMENT;

    @JacksonXmlProperty(localName = Documentation.NAME)
    private final Documentation documentation = new Documentation();

    @JacksonXmlProperty(localName = PlayerRoster.NAME)
    private final PlayerRoster roster = new PlayerRoster(settings.getTeams().size() * 2);

    @JacksonXmlProperty(localName = MODULE + "Chatter")
    private final EmptyElement chatter = EmptyElement.ELEMENT;

    @JacksonXmlProperty(localName = GlobalOptions.NAME)
    private final GlobalOptions globalOptions = new GlobalOptions();

    @JacksonXmlProperty(localName = CircuitChooser.NAME)
    private final CircuitChooser map = new CircuitChooser();

    @JacksonXmlProperty(localName = PieceWindow.NAME)
    private final PieceWindow pieceWindow = new PieceWindow(settings);

    @JacksonXmlProperty(localName = PrototypesContainer.NAME)
    private final PrototypesContainer prototypes =
            settings.getDashboardVersion() == 1 ? new PrototypesContainerV1() : new PrototypesContainerV2();

    @JacksonXmlProperty(localName = GamePieceImageDefinitions.NAME)
    private final GamePieceImageDefinitions gamePieceDefs = new GamePieceImageDefinitions();

    @JacksonXmlProperty(localName = MODULE + "properties.GlobalProperties")
    private final EmptyElement globalProps = EmptyElement.ELEMENT;

    @JacksonXmlProperty(localName = VASSAL + "i18n.Language")
    private final EmptyElement language = EmptyElement.ELEMENT;

    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = SpecialDiceButton.NAME)
    private final List<SpecialDiceButton> dices = new ArrayList<>(7);

    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = AbstractDashboard.NAME)
    private final List<AbstractDashboard> dashboards;

    @JacksonXmlProperty(localName = TurnTracker.NAME)
    private final TurnTracker turnTracker = new TurnTracker();

    public ModuleBuild(Settings settings) {
        super(settings);
        this.description = settings.getDescription();
        this.vassalVersion = settings.getVassalVersion();
        this.moduleVersion = settings.getModuleVersion();

        dices.add(getGearDie(1, 4, HotKey.F1));
        dices.add(getGearDie(2, 6, HotKey.F2));
        dices.add(getGearDie(3, 8, HotKey.F3));
        dices.add(getGearDie(4, 12, HotKey.F4));
        dices.add(getGearDie(5, 20, HotKey.F5));
        dices.add(getGearDie(6, 30, HotKey.F6));
        dices.add(new SpecialDiceButton(DICE_ROLL_MSG, HotKey.F7, StringUtils.EMPTY, "d20", true, true, false,
                StringUtils.EMPTY, "d20", Variable.NAME, 50, 50, getDie(20, D20)));

        String players = roster.getEntry().stream().collect(Collectors.joining(","));
        dashboards = new ArrayList<>(roster.getEntry().size());

        if (settings.getDashboardVersion() == 1) {
            settings.getTeams().forEach(team -> {
                dashboards.add(new DashboardV1(team.getId() + " " + 1, team.getMenuImage(), players, team, 1));
                dashboards.add(new DashboardV1(team.getId() + " " + 2, team.getMenuImage(), players, team, 2));
            });
        } else {
            settings.getTeams().forEach(team -> {
                dashboards.add(new DashboardV2(team.getId() + " " + 1, team.getMenuImage(), players, team, 1));
                dashboards.add(new DashboardV2(team.getId() + " " + 2, team.getMenuImage(), players, team, 2));
            });
        }
    }

    private static final String DICE_ROLL_MSG =
            "<" + Variable.PLAYER + "> rolls " + Variable.NAME + " = [" + Variable.RESULT_1 + "]";

    private static SpecialDiceButton getGearDie(int gear, int nbFaces, HotKey hotKey) {
        String digitSuffix = null;
        switch (gear) {
            case 1:
                digitSuffix = "st";
                break;
            case 2:
                digitSuffix = "nd";
                break;
            case 3:
                digitSuffix = "rd";
                break;
            default:
                digitSuffix = "th";
                break;
        }

        int[] die = GEAR_DICES[gear - 1];
        String diceName = gear + digitSuffix + " Gear";

        return new SpecialDiceButton(DICE_ROLL_MSG, hotKey, StringUtils.EMPTY, diceName, true, true, false,
                StringUtils.EMPTY, diceName, Variable.NAME, 50, 50, getDie(nbFaces, die));
    }

    private static SpecialDie getDie(int nbFaces, int[] die) {
        int firstValue = die[0];
        int lastValue = die[die.length - 1];

        List<SpecialDieFace> faces = new ArrayList<>(die.length);
        for (int i = 0; i < die.length; i++) {
            faces.add(new SpecialDieFace("Dado_" + firstValue + "-" + lastValue + "_" + die[i] + ".png",
                    String.valueOf(i + 1), String.valueOf(die[i])));
        }

        return new SpecialDie(Variable.NUM_VALUE.getVar(), "d" + nbFaces, faces);
    }

    private static final int[][] GEAR_DICES = { //
            {1, 2}, // 1st Gear
            {2, 3, 3, 4, 4, 4}, // 2nd Gear
            {4, 5, 6, 6, 7, 7, 8, 8}, // 3rd Gear
            {7, 8, 9, 10, 11, 12}, // 4th Gear
            {11, 12, 13, 14, 15, 16, 17, 18, 19, 20}, // 5th Gear
            {21, 22, 23, 24, 25, 26, 27, 28, 29, 30} // 6th Gear
    };

    private static final int[] D20 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
}
