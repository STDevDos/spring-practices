package com.froyo.mlt.messaging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * Scenario 18: Asynchronous messaging with Spring Cloud Stream.
 * Spring Cloud Stream uses functional programming models (Supplier, Consumer, Function)
 * to define message producers and consumers.
 */
@Configuration
public class StreamConfig {

    private static final Logger log = LoggerFactory.getLogger(StreamConfig.class);

    // Producer (Supplier)
    @Bean
    public Supplier<String> orderProducer() {
        return () -> {
            String message = "New order at " + System.currentTimeMillis();
            log.info("Producing message: {}", message);
            return message;
        };
    }

    // Consumer (Consumer)
    @Bean
    public Consumer<String> orderConsumer() {
        return message -> {
            log.info("Consuming message: {}", message);
        };
    }
}
