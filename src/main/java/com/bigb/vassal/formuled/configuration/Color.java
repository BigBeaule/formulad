package com.bigb.vassal.formuled.configuration;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Color {
    private int r;
    private int g;
    private int b;
    
    @JsonValue
    public String getRGB() {
        return new StringBuilder().append(r).append(',').append(g).append(',').append(b).toString();
    }
    
    @Override
    public String toString() {
        return getRGB();
    }
    
    public static final Color BLACK = new Color(0, 0, 0);
    public static final Color WHITE = new Color(255, 255, 255);
}

