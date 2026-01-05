package com.api.lab.domain;

import java.math.BigDecimal;
import java.time.Instant;

public class CryptoCurrency {

    private String id;
    private String symbol;
    private String name;
    private BigDecimal priceUsd;
    private Instant lastUpdated;

    public CryptoCurrency() {}

    public CryptoCurrency(String id, String symbol, String name, BigDecimal priceUsd, Instant lastUpdated) {
        this.id = id;
        this.symbol = symbol;
        this.name = name;
        this.priceUsd = priceUsd;
        this.lastUpdated = lastUpdated;
    }

   // ---- Getters ----

    public String getId() {
        return id;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPriceUsd() {
        return priceUsd;
    }

    public Instant getLastUpdated() {
        return lastUpdated;
    }

    // ---- Setters ----

    public void setId(String id) {
        this.id = id;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPriceUsd(BigDecimal priceUsd) {
        this.priceUsd = priceUsd;
    }

    public void setLastUpdated(Instant lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
}