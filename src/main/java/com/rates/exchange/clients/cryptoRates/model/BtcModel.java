package com.rates.exchange.clients.cryptoRates.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BtcModel {
    @JsonProperty("ETH")
    private Double ETH;
    @JsonProperty("USD")
    private Double USD;
    @JsonProperty("UAH")
    private Double UAH;

    public BtcModel() {
    }

    public Double getETH() {
        return ETH;
    }

    public void setETH(Double ETH) {
        this.ETH = ETH;
    }

    public Double getUSD() {
        return USD;
    }

    public void setUSD(Double USD) {
        this.USD = USD;
    }

    public Double getUAH() {
        return UAH;
    }

    public void setUAH(Double UAH) {
        this.UAH = UAH;
    }
}



        //https://min-api.cryptocompare.com/data/price?fsym=BTC&tsyms=ETH,USD,UAH
