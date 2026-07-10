package com.froyo.service.model.dto;

/**
 * DTO de entrada para consultas de Currency.
 * Usa Java Record (Java 16+): sin boilerplate de getters, equals, hashCode ni toString.
 */
public record CurrencyRequest(String currency) {
}
