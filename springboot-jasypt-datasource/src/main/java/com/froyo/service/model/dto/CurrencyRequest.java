package com.froyo.service.model.dto;

import java.util.Objects;

public class CurrencyRequest {

    private String currency;

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        CurrencyRequest that = (CurrencyRequest) o;
        return Objects.equals(currency, that.currency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(currency);
    }

    @Override
    public String toString() {
        return "CurrencyRequest{" +
                "currency='" + currency + '\'' +
                '}';
    }
}
