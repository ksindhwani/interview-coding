package com.example.travelperk.interview.question.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BPI {

    @JsonProperty("symbol")
    private String symbol;
    
    @JsonProperty("code")
    private String code;
    
    @JsonProperty("rate")
    private String rate;
    
    @JsonProperty("description")
    private String description;
    
    @JsonProperty("rateFloat")
    private float rateFloat;

    public BPI(String symbol, String code, String rate, String description, float rateFloat) {
        this.symbol = symbol;
        this.code = code;
        this.rate = rate;
        this.description = description;
        this.rateFloat = rateFloat;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getRateFloat() {
        return rateFloat;
    }

    public void setRateFloat(float rateFloat) {
        this.rateFloat = rateFloat;
    }
}
