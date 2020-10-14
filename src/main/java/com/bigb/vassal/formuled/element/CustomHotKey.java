package com.bigb.vassal.formuled.element;

/**
 * 
 */
public class CustomHotKey extends HotKey {
    private final String keyName;

    public CustomHotKey(String keyName) {
        super(63743, 0);
        this.keyName = keyName;
    }

    @Override
    public String getHotKey() {
        return super.getHotKey() + ',' + keyName;
    }

    public static final CustomHotKey ENABLE = new CustomHotKey("SetEnabled");
    public static final CustomHotKey DISABLE = new CustomHotKey("SetDisabled");
    public static final CustomHotKey INCREASE = new CustomHotKey("IncreaseBox");
    public static final CustomHotKey TOGGLE_ENABLED = new CustomHotKey("ToggleEnabled");

    public static final CustomHotKey GEAR_0 = new CustomHotKey("SetGear0");
    public static final CustomHotKey GEAR_1 = new CustomHotKey("SetGear1");
    public static final CustomHotKey GEAR_2 = new CustomHotKey("SetGear2");
    public static final CustomHotKey GEAR_3 = new CustomHotKey("SetGear3");
    public static final CustomHotKey GEAR_4 = new CustomHotKey("SetGear4");
    public static final CustomHotKey GEAR_5 = new CustomHotKey("SetGear5");
    public static final CustomHotKey GEAR_6 = new CustomHotKey("SetGear6");
    public static final CustomHotKey[] GEAR_KEYS = { GEAR_0, GEAR_1, GEAR_2, GEAR_3, GEAR_4, GEAR_5, GEAR_6 };

    public static final CustomHotKey ROLL_1 = new CustomHotKey("roll1");
    public static final CustomHotKey ROLL_2 = new CustomHotKey("roll2");
    public static final CustomHotKey ROLL_3 = new CustomHotKey("roll3");
    public static final CustomHotKey ROLL_4 = new CustomHotKey("roll4");
    public static final CustomHotKey ROLL_5 = new CustomHotKey("roll5");
    public static final CustomHotKey ROLL_6 = new CustomHotKey("roll6");
    public static final CustomHotKey[] ROLLS = { ROLL_1, ROLL_2, ROLL_3, ROLL_4, ROLL_5, ROLL_6 };

    public static final CustomHotKey DO_ROLL_1 = new CustomHotKey("doRoll1");
    public static final CustomHotKey DO_ROLL_2 = new CustomHotKey("doRoll2");
    public static final CustomHotKey DO_ROLL_3 = new CustomHotKey("doRoll3");
    public static final CustomHotKey DO_ROLL_4 = new CustomHotKey("doRoll4");
    public static final CustomHotKey DO_ROLL_5 = new CustomHotKey("doRoll5");
    public static final CustomHotKey DO_ROLL_6 = new CustomHotKey("doRoll6");
    public static final CustomHotKey[] DO_ROLLS = { DO_ROLL_1, DO_ROLL_2, DO_ROLL_3, DO_ROLL_4, DO_ROLL_5, DO_ROLL_6 };

    public static final CustomHotKey ROLL_D20 = new CustomHotKey("rollBlackDie");
    public static final CustomHotKey DO_TEST = new CustomHotKey("doTest");
    public static final CustomHotKey CLOSE_TEST = new CustomHotKey("closeTest");
    public static final CustomHotKey NEAR_TEST = new CustomHotKey("nearTest");
    public static final CustomHotKey EASY_TEST = new CustomHotKey("easyTest");
    public static final CustomHotKey REPORT_TEST_ENGINE = new CustomHotKey("reportTestEngine");
    public static final CustomHotKey REPORT_TEST_HAZARD = new CustomHotKey("reportTestHazard");
    public static final CustomHotKey REPORT_TEST_COLLISION = new CustomHotKey("reportTestCollision");
    public static final CustomHotKey TEST_ENGINE = new CustomHotKey("testEngine");
    public static final CustomHotKey TEST_HAZARD = new CustomHotKey("testHazard");
    public static final CustomHotKey TEST_COLLISION = new CustomHotKey("testCollision");
    public static final CustomHotKey ROLL_ENGINE = new CustomHotKey("rollEngine");
    public static final CustomHotKey ROLL_HAZARD = new CustomHotKey("rollHazard");
    public static final CustomHotKey ROLL_COLLISION = new CustomHotKey("rollCollision");
    public static final CustomHotKey LOSE_ENGINE = new CustomHotKey("loseEngine");
    public static final CustomHotKey LOSE_HAZARD = new CustomHotKey("loseHazard");
    public static final CustomHotKey LOSE_COLLISION = new CustomHotKey("loseCollision");

    public static final CustomHotKey INCREASE_GEAR = new CustomHotKey("IncGear");
    public static final CustomHotKey DECREASE_GEAR = new CustomHotKey("DecGear");

}
