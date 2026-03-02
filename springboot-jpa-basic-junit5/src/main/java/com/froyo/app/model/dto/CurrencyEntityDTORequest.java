package com.froyo.app.model.dto;

import java.util.Objects;

public class CurrencyEntityDTORequest {
    private Long id;
    private String currency;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
        CurrencyEntityDTORequest that = (CurrencyEntityDTORequest) o;
        return Objects.equals(id, that.id) && Objects.equals(currency, that.currency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, currency);
    }

    @Override
    public String toString() {
        return "CurrencyEntityDTORequest{" +
                "id=" + id +
                ", currency='" + currency + '\'' +
                '}';
    }
}
