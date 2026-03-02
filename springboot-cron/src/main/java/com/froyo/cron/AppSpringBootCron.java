package com.froyo.cron;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class AppSpringBootCron implements CommandLineRunner {

    private final CronProcess cronProcess;

    public AppSpringBootCron(CronProcess cronProcess) {
        this.cronProcess = cronProcess;
    }

    public static void main(String[] args) {
        SpringApplication.run(AppSpringBootCron.class, args);
    }

    @Override
    public void run(String... args) {
    }
}
