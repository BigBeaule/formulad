package com.bigb.vassal.formuled.configuration;

import java.util.List;
import lombok.Data;

/**
 * 
 */
@Data
public class Settings {
    private String vassalVersion;
    private String moduleVersion;
    private String description;
    private int dashboardVersion;
    private List<Team> teams;
}
