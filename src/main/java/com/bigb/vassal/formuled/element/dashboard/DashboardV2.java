package com.bigb.vassal.formuled.element.dashboard;

import java.util.stream.IntStream;

import com.bigb.vassal.formuled.configuration.Team;
import com.bigb.vassal.formuled.element.CustomHotKey;
import com.bigb.vassal.formuled.element.Expression;
import com.bigb.vassal.formuled.element.circuit.SetupStack;
import com.bigb.vassal.formuled.element.enums.CarResource;
import com.bigb.vassal.formuled.element.enums.NoStackType;
import com.bigb.vassal.formuled.element.enums.Prototype;
import com.bigb.vassal.formuled.element.enums.SystemProperty;
import com.bigb.vassal.formuled.element.enums.Tire;
import com.bigb.vassal.formuled.element.enums.Variable;
import com.bigb.vassal.formuled.element.piece.PieceSlot;
import com.bigb.vassal.formuled.element.trait.Button;
import com.bigb.vassal.formuled.element.trait.GlobalKey;
import com.bigb.vassal.formuled.element.trait.Marker;
import com.bigb.vassal.formuled.element.trait.NoStack;
import com.bigb.vassal.formuled.element.trait.PrototypeRef;
import com.bigb.vassal.formuled.element.trait.Traits;

/**
 * 
 */
public class DashboardV2 extends AbstractDashboard {
    public DashboardV2(String name, String icon, String players, Team team, int carNumber) {
        super(name, icon, players, team, carNumber, 2, r -> r == CarResource.TIRE ? 12 : 6);

        widgets.add(getInputBox(Variable.TEAM, "Team", 210, 60));
        widgets.add(getInputBox(Variable.DRIVER, "Driver", 462, 60));
        widgets.add(getPosition(592, 56));
        widgets.add(getLapButton(1));
        widgets.add(getLapButton(2));
        widgets.add(getLapButton(3));

        widgets.add(getGearPanel(team, carNumber, 807, 353));

        IntStream.range(1, 4).forEach(lap -> {
            for (Tire tire : Tire.values()) {
                widgets.add(getSelectedTire(tire, lap));
            }
        });

        widgets.add(getPitStop(1));
        widgets.add(getPitStop(2));

        for (int i = 0; i < CarResource.CAR_RESOURCE_V2.size(); i++) {
            CarResource resource = CarResource.CAR_RESOURCE_V2.get(i);

            switch (resource) {
            case TIRE:
                widgets.add(getClearTiresButton(team, carNumber));
                widgets.add(getCarResourceSetup(Prototype.SETUP_BOX_TIRES, resource, team, carNumber, 64, 125));
                IntStream.range(0, 12).forEach(index -> widgets.add(getCarResource(resource, team, carNumber,
                        (index + 1), 65 + (index % 4 * 45), 175 + (index / 4 * 51))));
                continue;
            case ENGINE:
                widgets.add(getCarResourceCheck(CustomHotKey.TEST_ENGINE, resource, team, carNumber, 402));
                break;
            case BODY:
                widgets.add(getCarResourceCheck(CustomHotKey.TEST_COLLISION, resource, team, carNumber, 468));
                break;
            case HOLDING:
                widgets.add(getCarResourceCheck(CustomHotKey.TEST_HAZARD, resource, team, carNumber, 531));
                break;
            default:
                break;
            }

            widgets.add(getCarResourceSetup(resource, team, carNumber, i));
            for (int j = 1; j <= 6; j++) {
                widgets.add(getCarResource(resource, team, carNumber, j, i));
            }
        }

        widgets.add(getRepair(1));
        widgets.add(getRepair(2));
    }

    private SetupStack getLapButton(int lap) {
        return getLapButton(lap, 590 + (lap * 103), 57);
    }

    private SetupStack getSelectedTire(Tire tire, int lap) {
        return getSelectedTire(tire, lap, 59 + (lap * 48), 371 + tire.getOffsetV2());
    }

    private SetupStack getPitStop(int lap) {
        return getPitStop(lap, 62 + (lap * 46), 515);
    }

    private SetupStack getCarResource(CarResource resource, Team team, int carNumber, int index, int resourceOrdinal) {
        return getCarResource(resource, team, carNumber, index, 275 + (int) (resourceOrdinal * 64.5),
                231 + (index * 52));
    }

    private SetupStack getCarResourceSetup(CarResource resource, Team team, int carNumber, int resourceOrdinal) {
        return getCarResourceSetup(Prototype.SETUP_BOX, resource, team, carNumber, 275 + (int) (resourceOrdinal * 64.5),
                182);
    }
    
    private SetupStack getClearTiresButton(Team team, int carNumber) {
        String name = "Clear Used Tires";
        Traits traits = new Traits(getNextId(), "clear.png", name);
        traits.addTrait(new Marker(Variable.CAR.getVarName(), team.getId() + " " + carNumber));
        traits.addTrait(new PrototypeRef(Prototype.CLEAR_TIRES));
        return new SetupStack("ClearUsedTires", 201, 125, new PieceSlot(name, 0, 0, traits));
    }

    private SetupStack getCarResourceCheck(CustomHotKey testAction, CarResource resource, Team team, int carNumber,
            int x) {
        String name = resource.getType() + " Test";
        Traits traits = new Traits(getNextId(), "unused.png", name);
        traits.addTrait(new Marker(Variable.CAR.getVarName(), team.getId() + " " + carNumber));
        traits.addTrait(new GlobalKey("Execute Test", null, CustomHotKey.DO_TEST, testAction,
                new Expression(SystemProperty.CURRENT_MAP.getVarName() + "=" + CIRCUIT_MAP + " && "
                        + Variable.CAR.getVarName() + "=" + Variable.CAR + //
                        " && " + Variable.IS_CAR.getVarName() + "=true")));
        traits.addTrait(new Button("Roll Test Button", CustomHotKey.DO_TEST, 40, 40, -20, -20));
        traits.addTrait(new NoStack(NoStackType.NEVER_NORMALLY_NEVER));
        return new SetupStack(resource.getType() + "TestButton", x, 231, new PieceSlot(name, 0, 0, traits));
    }

    private SetupStack getRepair(int index) {
        return getRepair(index, 608, 73 + (index * 50));
    }
}
