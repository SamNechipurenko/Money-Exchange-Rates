package com.rates.exchange.clients.cryptoRates.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EthModel {
    @JsonProperty("USD")
    private Double USD;

    public EthModel(){

    }

    public Double getUSD() {
        return USD;
    }

    public void setUSD(Double USD) {
        this.USD = USD;
    }
}
