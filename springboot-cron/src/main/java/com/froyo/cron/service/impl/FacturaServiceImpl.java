package com.froyo.cron.service.impl;

import com.froyo.cron.service.FacturaService;
import com.froyo.cron.service.MailService;
import org.springframework.stereotype.Service;

@Service
public class FacturaServiceImpl implements FacturaService {

    private final MailService mailService;

    public FacturaServiceImpl(MailService mailService) {
        this.mailService = mailService;
    }

    @Override
    public void createFactura() {
        System.out.println("Creando factura...");
        mailService.sendMail();
    }

    @Override
    public void sendBalance() {
        System.out.println("Enviando balance...");
        mailService.sendMail();
    }
}
