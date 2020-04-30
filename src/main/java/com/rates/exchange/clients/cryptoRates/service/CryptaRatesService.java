package com.rates.exchange.clients.cryptoRates.service;

import com.rates.exchange.clients.cryptoRates.model.BtcModel;
import com.rates.exchange.clients.cryptoRates.model.EthModel;
import org.springframework.web.client.RestTemplate;

public class CryptaRatesService {
    private RestTemplate restTemplate = new RestTemplate();
    public static final String BTC_URL = "https://min-api.cryptocompare.com/data/price?fsym=BTC&tsyms=ETH,USD,UAH";
    public static final String ETH_URL = "https://min-api.cryptocompare.com/data/price?fsym=ETH&tsyms=USD";

    public BtcModel getBtcCurrentRates(){
        return restTemplate.getForObject(BTC_URL, BtcModel.class);
    }
    public EthModel getEthCurrentRates(){
        return restTemplate.getForObject(BTC_URL, EthModel.class);
    }
}
