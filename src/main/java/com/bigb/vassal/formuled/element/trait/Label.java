package com.bigb.vassal.formuled.element.trait;

import com.bigb.vassal.formuled.configuration.Color;
import com.bigb.vassal.formuled.element.HotKey;
import com.bigb.vassal.formuled.element.enums.Font;
import com.bigb.vassal.formuled.element.enums.Position;

/**
 * 
 */
public class Label extends AbstractTrait {
    private final String text;
    
    public Label(String description, String text, String nameFormat, String propertyName, String menuCommand,
            HotKey keyboardCommand, Font font, int fontSize, boolean bold, boolean italic, Color backgroundColor,
            Color textColor, Position verticalPosition, Position verticalJustification, int verticalOffset,
            Position horizontalPosition, Position horizontalJustification, int horizontalOffset, int rotation) {

        super("label", keyboardCommand, menuCommand, fontSize, backgroundColor, textColor, verticalPosition,
                verticalOffset, horizontalPosition, horizontalOffset, verticalJustification, horizontalJustification,
                nameFormat, font, getTextAttribute(bold, italic), rotation, propertyName, description);
        
        this.text = text;
    }
    
    @Override
    public Object getClosingValue() {
        return text;
    }
    
    @Override
    protected Object closeTrait() {
        return getClosingValue();
    }

    private static int getTextAttribute(boolean bold, boolean italic) {
        if (bold && italic) {
            return 3;
        }

        return bold ? 1 : (italic ? 2 : 0);
    }
}
