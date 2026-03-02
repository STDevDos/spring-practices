package com.froyo.practice.config;

import org.ehcache.config.builders.CacheConfigurationBuilder;
import org.ehcache.config.builders.ResourcePoolsBuilder;
import org.ehcache.config.builders.ExpiryPolicyBuilder;
import org.ehcache.jsr107.Eh107Configuration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.cache.CacheManager;
import javax.cache.Caching;
import javax.cache.spi.CachingProvider;
import java.lang.reflect.Method;
import java.time.Duration;
import java.util.Arrays;

@Configuration
@EnableCaching
public class EhcacheConfig {

    @Bean
    public KeyGenerator multiplyKeyGenerator() {
        return (Object target, Method method, Object... params) -> method.getName() + "_" + Arrays.toString(params);
    }

    @Bean
    public CacheManager cacheManager() {
        CachingProvider provider = Caching.getCachingProvider();
        CacheManager cacheManager = provider.getCacheManager();

        org.ehcache.config.CacheConfiguration<Object, Object> tenSecondConfig = CacheConfigurationBuilder
                .newCacheConfigurationBuilder(Object.class, Object.class, ResourcePoolsBuilder.heap(1000))
                .withExpiry(ExpiryPolicyBuilder.timeToLiveExpiration(Duration.ofSeconds(10)))
                .build();

        org.ehcache.config.CacheConfiguration<Object, Object> twentySecondConfig = CacheConfigurationBuilder
                .newCacheConfigurationBuilder(Object.class, Object.class, ResourcePoolsBuilder.heap(1000))
                .withExpiry(ExpiryPolicyBuilder.timeToLiveExpiration(Duration.ofSeconds(20)))
                .build();

        org.ehcache.config.CacheConfiguration<Object, Object> tenMinutesConfig = CacheConfigurationBuilder
                .newCacheConfigurationBuilder(Object.class, Object.class, ResourcePoolsBuilder.heap(1000))
                .withExpiry(ExpiryPolicyBuilder.timeToLiveExpiration(Duration.ofMinutes(10)))
                .build();

        if (cacheManager.getCache("ten-second-cache") == null) {
            cacheManager.createCache("ten-second-cache",
                    Eh107Configuration.fromEhcacheCacheConfiguration(tenSecondConfig));
        }
        if (cacheManager.getCache("twenty-second-cache") == null) {
            cacheManager.createCache("twenty-second-cache",
                    Eh107Configuration.fromEhcacheCacheConfiguration(twentySecondConfig));
        }
        if (cacheManager.getCache("ten-minutes-cache") == null) {
            cacheManager.createCache("ten-minutes-cache",
                    Eh107Configuration.fromEhcacheCacheConfiguration(tenMinutesConfig));
        }

        return cacheManager;
    }
}
