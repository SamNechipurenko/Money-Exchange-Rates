package com.rates.exchange.clients.moneyRates.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DollarRates {
    @JsonProperty("RUB")
    private Double RUB;
    @JsonProperty("UAH")
    private Double UAH;

    public DollarRates() {
    }

    public Double getRUB() {
        return RUB;
    }

    public void setRUB(Double RUB) {
        this.RUB = RUB;
    }

    public Double getUAH() {
        return UAH;
    }

    public void setUAH(Double UAH) {
        this.UAH = UAH;
    }
}
