package com.api.lab.services;

import com.api.lab.domain.CryptoCurrency;
import com.api.lab.repositories.CryptoRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class CryptoService {

    private final CryptoRepository repository;
    private final CoinGeckoClient coinGeckoClient;

    public CryptoService(CryptoRepository repository, CoinGeckoClient coinGeckoClient) {
        this.repository = repository;
        this.coinGeckoClient = coinGeckoClient;
    }

    public CryptoCurrency getCrypto(String id) {
        CryptoCurrency crypto = repository.findById(id);

        if (crypto == null) {
            crypto = refreshCrypto(id);
        }

        return crypto;
    }

    public CryptoCurrency refreshCrypto(String id) {
        var price = coinGeckoClient.getPrice(id);

        CryptoCurrency crypto = new CryptoCurrency();
        crypto.setId(id);
        crypto.setPriceUsd(price);
        crypto.setLastUpdated(Instant.now());

        return repository.save(crypto);
    }

    public Iterable<CryptoCurrency> getAll() {
        return repository.findAll();
    }
}
