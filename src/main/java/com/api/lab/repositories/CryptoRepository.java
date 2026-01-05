package com.api.lab.repositories;

import com.api.lab.domain.CryptoCurrency;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class CryptoRepository {

    private final Map<String, CryptoCurrency> cache = new ConcurrentHashMap<>();

    public CryptoCurrency save(CryptoCurrency crypto) {
        cache.put(crypto.getId(), crypto);
        return crypto;
    }

    public CryptoCurrency findById(String id) {
        return cache.get(id);
    }

    public Collection<CryptoCurrency> findAll() {
        return cache.values();
    }

    public void delete(String id) {
        cache.remove(id);
    }

    public boolean exists(String id) {
        return cache.containsKey(id);
    }
}