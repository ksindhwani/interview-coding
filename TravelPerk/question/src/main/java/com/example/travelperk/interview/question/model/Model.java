package com.example.travelperk.interview.question.model;

import java.util.HashMap;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Model {
    
    @JsonProperty("time")
    private Time time;
    
    @JsonProperty("disclaimer")
    private String disclaimer;
    
    @JsonProperty("chartName")
    private String chartName;
    
    @JsonProperty("bpi")
    private HashMap<String, BPI> bpi;
    
    public Model(Time time, String disclaimer, String chartName, HashMap<String, BPI> bpi) {
        this.time = time;
        this.disclaimer = disclaimer;
        this.chartName = chartName;
        this.bpi = bpi;
    }

    public Time getTime() {
        return time;
    }

    public String getDisclaimer() {
        return disclaimer;
    }

    public String getChartName() {
        return chartName;
    }

    public HashMap<String, BPI> getBpi() {
        return bpi;
    }    
}
