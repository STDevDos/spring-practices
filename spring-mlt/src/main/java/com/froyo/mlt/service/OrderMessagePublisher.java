package com.froyo.mlt.service;

import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Service;

@Service
public class OrderMessagePublisher {

    private final StreamBridge streamBridge;

    public OrderMessagePublisher(StreamBridge streamBridge) {
        this.streamBridge = streamBridge;
    }

    /**
     * Alex integrates Spring Cloud Stream to enhance scalability and
     * responsiveness.
     * This makes efficient asynchronous communication and coordination among
     * microservices.
     */
    public void publishOrderCreated(String orderDetails) {
        System.out.println("Publishing order to Kafka/RabbitMQ: " + orderDetails);
        streamBridge.send("output", orderDetails);
    }
}
