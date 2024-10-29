package com.techelevator.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TaxRateResponse {
    @JsonProperty("salesTax")
    private Double rate;

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }
}

