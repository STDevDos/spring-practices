package com.froyo.service.model.entity.listener;

import com.froyo.service.model.entity.CurrencyEntity;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import jakarta.persistence.PrePersist;
import jakarta.persistence.PreRemove;

public class CurrencyListener {

    private static final Logger log = LogManager.getLogger(CurrencyListener.class);

    @PrePersist
    public void salvar(CurrencyEntity currency) {
        log.info("save CURRENCY: " + currency.getCurrency());
    }

    @PreRemove
    public void borrar(CurrencyEntity currency) {
        log.info("remove CURRENCY: " + currency.getCurrency());
    }

}

