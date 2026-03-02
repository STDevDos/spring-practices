package com.froyo.mlt.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * Scenario 12: JWT Invalidation
 * Sophia implements a strategy to invalidate tokens upon logout using a blacklist.
 */
@Service
public class TokenBlacklistService {

    private static final Logger log = LoggerFactory.getLogger(TokenBlacklistService.class);
    
    // In a real application, this should be stored in Redis with a TTL (Time To Live) 
    // matching the token expiration.
    private final Set<String> blacklistedTokens = new HashSet<>();

    public void blacklistToken(String token) {
        log.info("Token blacklisted: {}", token);
        blacklistedTokens.add(token);
    }

    public boolean isTokenBlacklisted(String token) {
        return blacklistedTokens.contains(token);
    }
}
