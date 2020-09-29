package com.bigb.vassal.formuled.element.trait;

/**
 * 
 */
public class Marker extends AbstractTrait {
    private final Object value;
    
    public Marker(String property, Object value) {
        super("mark", property);
        this.value = value;
    }
    
    @Override
    public Object getClosingValue() {
        return value;
    }
    
    
    @Override
    protected Object closeTrait() {
        return getClosingValue();
    }
}
