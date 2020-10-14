package com.bigb.vassal.formuled.element;

import com.fasterxml.jackson.annotation.JsonValue;
import org.apache.commons.lang3.StringUtils;

/**
 * 
 */
public class HotKey {
    private final int[] keysCode;

    public HotKey(int... keysCode) {
        this.keysCode = keysCode;
    }

    @JsonValue
    public String getHotKey() {
        return StringUtils.join(keysCode, ',');
    }

    @Override
    public String toString() {
        return this.getHotKey();
    }

    public static final HotKey NONE = new HotKey();
    public static final HotKey CTRL_1 = new HotKey(49, 130);
    public static final HotKey CTRL_2 = new HotKey(50, 130);
    public static final HotKey CTRL_3 = new HotKey(51, 130);
    public static final HotKey CTRL_A = new HotKey(65, 130);
    public static final HotKey CTRL_B = new HotKey(66, 130);
    public static final HotKey CTRL_C = new HotKey(67, 130);
    public static final HotKey CTRL_D = new HotKey(68, 130);
    public static final HotKey CTRL_E = new HotKey(69, 130);
    public static final HotKey CTRL_Q = new HotKey(81, 130);
    public static final HotKey CTRL_R = new HotKey(82, 130);
    public static final HotKey CTRL_S = new HotKey(83, 130);
    public static final HotKey CTRL_T = new HotKey(84, 130);
    public static final HotKey CTRL_W = new HotKey(87, 130);
    public static final HotKey CTRL_X = new HotKey(88, 130);
    public static final HotKey CTRL_Z = new HotKey(90, 130);
    public static final HotKey CTRL_SPACE = new HotKey(32, 130);
    public static final HotKey CTRL_SHIFT_O = new HotKey(79, 195);
    public static final HotKey CTRL_SHIFT_Q = new HotKey(81, 195);
    public static final HotKey CTRL_SHIFT_T = new HotKey(84, 195);
    public static final HotKey CTRL_SHIFT_W = new HotKey(87, 195);

    public static final HotKey ALT_S = new HotKey(83, 520);
    
    public static final HotKey F1 = new HotKey(112, 0);
    public static final HotKey F2 = new HotKey(113, 0);
    public static final HotKey F3 = new HotKey(114, 0);
    public static final HotKey F4 = new HotKey(115, 0);
    public static final HotKey F5 = new HotKey(116, 0);
    public static final HotKey F6 = new HotKey(117, 0);
    public static final HotKey F7 = new HotKey(118, 0);
    
    public static final HotKey ENTER = new HotKey(10, 0);
    public static final HotKey PAGE_DOWN = new HotKey(34, 0);
}
