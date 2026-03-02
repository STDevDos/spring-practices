package com.froyo.mlt.service;

import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ProductService {

    private final Map<Long, String> database = new HashMap<>();

    /**
     * Write-through caching strategy:
     * The cache is updated only when the database is modification occurs.
     * @CachePut ensures the result is stored in the cache after the method execution.
     */
    @CachePut(value = "products", key = "#id")
    public String updateProduct(Long id, String name) {
        System.out.println("Updating database for product: " + id);
        database.put(id, name);
        return name;
    }

    @Cacheable(value = "products", key = "#id")
    public String getProduct(Long id) {
        System.out.println("Fetching from database (Cache Miss) for product: " + id);
        return database.get(id);
    }
}
