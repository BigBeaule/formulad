package com.bigb.vassal.formuled.element.dashboard;

import java.util.stream.IntStream;

import com.bigb.vassal.formuled.configuration.Team;
import com.bigb.vassal.formuled.element.circuit.SetupStack;
import com.bigb.vassal.formuled.element.enums.CarResource;
import com.bigb.vassal.formuled.element.enums.Prototype;
import com.bigb.vassal.formuled.element.enums.Tire;
import com.bigb.vassal.formuled.element.enums.Variable;

/**
 * 
 */
public class DashboardV2 extends AbstractDashboard {
    public DashboardV2(String name, String icon, String players, Team team, int carNumber) {
        super(name, icon, players, team, carNumber, 2);

        widgets.add(getInputBox(Variable.TEAM, "Team", 210, 60));
        widgets.add(getInputBox(Variable.DRIVER, "Driver", 462, 60));
        widgets.add(getPosition(592, 56));
        widgets.add(getLapButton(1));
        widgets.add(getLapButton(2));
        widgets.add(getLapButton(3));

        widgets.add(getGearPanel(team, carNumber, 807, 348));

        IntStream.range(1, 4).forEach(lap -> {
            for (Tire tire : Tire.values()) {
                widgets.add(getSelectedTire(tire, lap));
            }
        });

        widgets.add(getPitStop(1));
        widgets.add(getPitStop(2));

        int resourceOrdinal = 0;
        for (CarResource resource : CarResource.CAR_RESOURCE_V2) {
            if (resource == CarResource.TIRE) {
                widgets.add(getCarResourceSetup(Prototype.SETUP_BOX_TIRES, resource, team, carNumber, 64, 125));
                IntStream.range(0, 12).forEach(index -> widgets
                        .add(getCarResource(resource, (index + 1), 65 + (index % 4 * 45), 175 + (index / 4 * 51))));
            } else {
                widgets.add(getCarResourceSetup(resource, team, carNumber, resourceOrdinal));

                final int ro = resourceOrdinal++;
                IntStream.range(1, 7).forEach(index -> widgets.add(getCarResource(resource, index, ro)));
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

    private SetupStack getCarResource(CarResource resource, int index, int resourceOrdinal) {
        return getCarResource(resource, index, 275 + (int) (resourceOrdinal * 64.5), 231 + (index * 52));
    }

    private SetupStack getCarResourceSetup(CarResource resource, Team team, int carNumber, int resourceOrdinal) {
        return getCarResourceSetup(Prototype.SETUP_BOX, resource, team, carNumber, 275 + (int) (resourceOrdinal * 64.5), 182);
    }

    private SetupStack getRepair(int index) {
        return getRepair(index, 608, 73 + (index * 50));
    }
}
