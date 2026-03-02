package com.froyo.mlt.service;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class PaymentService {

    private static final Logger log = LoggerFactory.getLogger(PaymentService.class);
    private final Random random = new Random();

    /**
     * Scenario 11: Retry and Circuit Breaker
     * Alex uses @Retryable to handle transient failures and @CircuitBreaker to prevent consecutive failures.
     */
    @Retryable(value = { RuntimeException.class }, maxAttempts = 3, backoff = @Backoff(delay = 1000))
    @CircuitBreaker(name = "paymentGateway", fallbackMethod = "processPaymentFallback")
    public String processPayment(String orderId) {
        log.info("Attempting to process payment for order: {}", orderId);
        
        // Simulate external gateway failure
        if (random.nextInt(10) < 7) { // 70% failure rate for simulation
            log.error("Payment gateway failure for order: {}", orderId);
            throw new RuntimeException("Gateway Timeout");
        }
        
        return "Payment processed successfully for " + orderId;
    }

    @Recover
    public String recover(RuntimeException e, String orderId) {
        log.warn("Recovery logic for order {}: {}", orderId, e.getMessage());
        return "Payment failed after retries. Notifying customer service.";
    }

    // Fallback for Circuit Breaker
    public String processPaymentFallback(String orderId, Exception e) {
        log.error("Circuit Breaker fallback for order {}: {}", orderId, e.getMessage());
        return "Circuit is OPEN. Please try again later.";
    }
}
