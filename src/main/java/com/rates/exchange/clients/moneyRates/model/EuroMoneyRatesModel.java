package com.rates.exchange.clients.moneyRates.model;

public class EuroMoneyRatesModel {

    private String result;
    private String base;
    private EuroRates conversion_rates;
    private Integer time_last_update;

    public EuroMoneyRatesModel() {
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public EuroRates getConversion_rates() {
        return conversion_rates;
    }

    public void setConversion_rates(EuroRates conversion_rates) {
        this.conversion_rates = conversion_rates;
    }

    public Integer getTime_last_update() {
        return time_last_update;
    }

    public void setTime_last_update(Integer time_last_update) {
        this.time_last_update = time_last_update;
    }
}
