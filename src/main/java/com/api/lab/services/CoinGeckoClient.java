package com.api.lab.services;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.Map;

@Component
public class CoinGeckoClient {

    private static final String URL =
            "https://api.coingecko.com/api/v3/coins/markets" +
            "?vs_currency=usd&ids={id}";

    private final RestTemplate restTemplate = new RestTemplate();

    public BigDecimal getPrice(String cryptoId) {
        Object[] response = restTemplate.getForObject(URL, Object[].class, Map.of("id", cryptoId));

        if (response == null || response.length == 0) {
            throw new RuntimeException("Crypto not found: " + cryptoId);
        }

        Map<?, ?> data = (Map<?, ?>) response[0];
        return new BigDecimal(data.get("current_price").toString());
    }
}
