package com.froyo.app.model.dto;

/**
 * DTO de entrada para operaciones CRUD sobre Currency.
 * Usa Java Record (Java 16+): sin boilerplate de getters, equals, hashCode ni toString.
 */
public record CurrencyEntityDTORequest(Long id, String currency) {
}
