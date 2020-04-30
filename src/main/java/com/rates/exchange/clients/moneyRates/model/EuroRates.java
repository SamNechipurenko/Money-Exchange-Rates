package com.rates.exchange.clients.moneyRates.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EuroRates {
    @JsonProperty("USD")
    private Double USD;

    public EuroRates() {
    }

    public Double getUSD() {
        return USD;
    }

    public void setUSD(Double USD) {
        this.USD = USD;
    }
}
