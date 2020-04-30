package com.rates.exchange.clients.moneyRates.service;

import com.rates.exchange.clients.moneyRates.model.DollarMoneyRatesModel;
import com.rates.exchange.clients.moneyRates.model.EuroMoneyRatesModel;
import org.springframework.web.client.RestTemplate;

public class MoneyRatesService {
    //https://prime.exchangerate-api.com/v5/49ab2683fed5629253fed27a/latest/USD
    private RestTemplate restTemplate = new RestTemplate();
    public static final String URL = "https://prime.exchangerate-api.com/v5/49ab2683fed5629253fed27a/latest/";

    public DollarMoneyRatesModel getDollarCurrentRates(String greenback){

        return restTemplate.getForObject(URL + greenback, DollarMoneyRatesModel.class);
    }


    public EuroMoneyRatesModel getEuroCurrentRates(String greenback){

        return restTemplate.getForObject(URL + greenback, EuroMoneyRatesModel.class);
    }
}
