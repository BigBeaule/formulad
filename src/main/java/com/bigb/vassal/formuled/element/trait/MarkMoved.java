package com.bigb.vassal.formuled.element.trait;

import com.bigb.vassal.formuled.element.HotKey;

/**
 * 
 */
public class MarkMoved extends AbstractTrait {
    public MarkMoved(String command, HotKey keyboardCommand) {
        this(command, keyboardCommand, null, 0, 0);
    }
    

    public MarkMoved(String command, HotKey keyboardCommand, String markerImage, int horizontalOffset,
            int verticalOffset) {
        
        super("markmoved", markerImage, horizontalOffset, verticalOffset, command, keyboardCommand);
    }
    
    @Override
    protected Object closeTrait() {
        return Boolean.FALSE;
    }
}
