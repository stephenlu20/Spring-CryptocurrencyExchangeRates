package com.api.lab.scheduler;

import com.api.lab.repositories.CryptoRepository;
import com.api.lab.services.CryptoService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class CryptoRefreshScheduler {

    private final CryptoRepository repository;
    private final CryptoService service;

    public CryptoRefreshScheduler(CryptoRepository repository, CryptoService service) {
        this.repository = repository;
        this.service = service;
    }

    @Scheduled(fixedRate = 300_000) // 5 minutes
    public void refreshAll() {
        repository.findAll()
                  .forEach(c -> service.refreshCrypto(c.getId()));
    }
}
