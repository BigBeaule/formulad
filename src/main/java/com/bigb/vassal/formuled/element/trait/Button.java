package com.bigb.vassal.formuled.element.trait;

import com.bigb.vassal.formuled.element.HotKey;

/**
 * 
 */
public class Button extends AbstractTrait {
    public Button(String description, HotKey key, int width, int height, int xOffset, int yOffset) {
        super("button", key, xOffset, yOffset, width, height, description);
    }
}
