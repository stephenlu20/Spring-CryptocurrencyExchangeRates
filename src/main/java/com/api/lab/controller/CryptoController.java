package com.api.lab.controller;

import com.api.lab.domain.CryptoCurrency;
import com.api.lab.services.CryptoService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/crypto")
public class CryptoController {

    private final CryptoService service;

    public CryptoController(CryptoService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public CryptoCurrency getCrypto(@PathVariable String id) {
        return service.getCrypto(id);
    }

    @GetMapping
    public Iterable<CryptoCurrency> getAll() {
        return service.getAll();
    }
}
