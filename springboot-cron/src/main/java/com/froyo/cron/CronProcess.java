package com.froyo.cron;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class CronProcess {

    @Scheduled(cron = "0 0/1 * 1/1 * ?")
    public void process() {
        System.out.println("Cron manual a las: " + new Date());
    }

    @Scheduled(fixedRate = 5000)
    public void process2() {
        System.out.println("Cron cada 5 segundos: " + new Date());
    }

}
