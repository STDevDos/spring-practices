package com.froyo.mlt.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

/**
 * Scenario 19: Managing asynchronous tasks without manually managing thread pools.
 * By using @Async and @EnableAsync, Spring Boot manages the thread pool automatically.
 */
@Service
public class AsyncOrderService {

    private static final Logger log = LoggerFactory.getLogger(AsyncOrderService.class);

    @Async
    public void processOrderAsynchronously(String orderId) {
        log.info("Processing order {} in thread {}", orderId, Thread.currentThread().getName());
        try {
            // Simulate heavy processing
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        log.info("Finished processing order {} in thread {}", orderId, Thread.currentThread().getName());
    }

    @Async
    public CompletableFuture<String> processOrderWithResult(String orderId) {
        log.info("Processing order with result {} in thread {}", orderId, Thread.currentThread().getName());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return CompletableFuture.completedFuture("Order " + orderId + " processed successfully");
    }
}
