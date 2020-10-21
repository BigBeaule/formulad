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
public class DashboardV1 extends AbstractDashboard {
    public DashboardV1(String name, String icon, String players, Team team, int carNumber) {
        super(name, icon, players, team, carNumber, 3, r -> 9);

        widgets.add(getInputBox(Variable.TEAM, "Team", 233, 70));
        widgets.add(getInputBox(Variable.DRIVER, "Driver", 538, 70));
        widgets.add(getPosition(719, 68));
        widgets.add(getLapButton(1));
        widgets.add(getLapButton(2));
        widgets.add(getLapButton(3));

        widgets.add(getGearPanel(team, carNumber, 582, 159));

        IntStream.range(1, 4).forEach(lap -> {
            for (Tire tire : Tire.values()) {
                widgets.add(getSelectedTire(tire, lap));
            }
        });

        widgets.add(getPitStop(1));
        widgets.add(getPitStop(2));

        int resourceOrdinal = 0;
        for (CarResource resource : CarResource.CAR_RESOURCE_V1) {
            widgets.add(getCarResourceSetup(resource, team, carNumber, resourceOrdinal));

            final int ro = resourceOrdinal++;
            IntStream.range(1, 10).forEach(index -> widgets.add(getCarResource(resource, team, carNumber, index, ro)));
        }

        widgets.add(getRepair(1));
        widgets.add(getRepair(2));
    }

    private SetupStack getLapButton(int lap) {
        return getLapButton(lap, 717 + (lap * 125), 70);
    }

    private SetupStack getSelectedTire(Tire tire, int lap) {
        return getSelectedTire(tire, lap, 938 + tire.getOffsetV1(), 320 + (lap * 58));
    }

    private SetupStack getPitStop(int lap) {
        return getPitStop(lap, 1092, 320 + (lap * 58));
    }

    private SetupStack getCarResource(CarResource resource, Team team, int carNumber, int index, int resourceOrdinal) {
        return getCarResource(Prototype.DASH_BOX, resource, team, carNumber, index, 141 + (index * 52),
                342 + (resourceOrdinal * 58));
    }

    private SetupStack getCarResourceSetup(CarResource resource, Team team, int carNumber, int resourceOrdinal) {
        return getCarResourceSetup(Prototype.SETUP_BOX, resource, team, carNumber, 75, 342 + (resourceOrdinal * 58));
    }

    private SetupStack getRepair(int index) {
        return getRepair(index, 145 + (index * 50), 690);
    }
}
