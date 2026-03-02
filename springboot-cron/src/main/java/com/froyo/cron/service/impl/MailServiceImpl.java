package com.froyo.cron.service.impl;

import com.froyo.cron.service.MailService;
import org.springframework.stereotype.Service;

@Service
public class MailServiceImpl implements MailService {

    @Override
    public void sendMail() {
        System.out.println("Enviando mail...");
    }
}
