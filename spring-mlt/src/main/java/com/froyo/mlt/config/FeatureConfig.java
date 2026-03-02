package com.froyo.mlt.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Scenario 14: Conditional Annotations
 * Michael uses @ConditionalOnProperty to configure beans based on the presence of a property.
 */
@Configuration
public class FeatureConfig {

    private static final Logger log = LoggerFactory.getLogger(FeatureConfig.class);

    @Bean
    @ConditionalOnProperty(name = "feature.payment.v2.enabled", havingValue = "true")
    public String newPaymentEngine() {
        log.info("New Payment Engine V2 initialized!");
        return "Advanced Engine V2";
    }

    @Bean
    @ConditionalOnProperty(name = "feature.payment.v2.enabled", havingValue = "false", matchIfMissing = true)
    public String legacyPaymentEngine() {
        log.info("Legacy Payment Engine initialized!");
        return "Standard Engine V1";
    }
}

