package com.bigb.vassal.formuled.element.trait;

import com.bigb.vassal.formuled.element.HotKey;

/**
 * 
 */
public class Rotate extends AbstractTrait {
    private final int closingValue;
    
    public Rotate(String description, HotKey rotateCommand, String menuText) {
        super("rotate", 1, rotateCommand, menuText, null, description, null);
        this.closingValue = 0;
    }
    
    public Rotate(String description, int facing, HotKey clockwiseKey, String clockwiseMenu, HotKey counterClockwiseKey,
            String counterClockwiseMenu, int closingValue) {
        
        super("rotate", facing, HotKey.CTRL_W, HotKey.CTRL_Q, clockwiseMenu, counterClockwiseMenu, null, null,
                description);
        
        this.closingValue = closingValue;
    }
    
    @Override
    protected Object closeTrait() {
        return this.closingValue;
    }
}
