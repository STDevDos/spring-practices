package com.froyo.mlt.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

@Service
@EnableAsync
public class StockMarketService {

    /**
     * Sarah implements an asynchronous processing approach using @Async.
     * This mitigates performance bottlenecks by offloading long-running
     * data processing tasks to a separate thread pool.
     */
    @Async
    public void processStockData(String stockSymbol, Double price) {
        System.out.println("Processing stock data asynchronously for: " + stockSymbol + " Price: " + price);
        try {
            // Simulate heavy processing
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Processing finished for: " + stockSymbol);
    }
}
