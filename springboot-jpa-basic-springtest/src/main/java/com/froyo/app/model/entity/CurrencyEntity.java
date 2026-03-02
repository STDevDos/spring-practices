package com.froyo.app.model.entity;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "currency", uniqueConstraints = {
        @UniqueConstraint(columnNames = "currency", name = "uniqueCurrencyConstraint")
})
public class CurrencyEntity implements Serializable {

    private static final long serialVersionUID = 6734139637088679530L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Each currency will be given an auto-generated unique identifier when stored

    @Column(name = "currency", nullable = false)
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
        CurrencyEntity that = (CurrencyEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(currency, that.currency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, currency);
    }

    @Override
    public String toString() {
        return "CurrencyEntity{" +
                "id=" + id +
                ", currency='" + currency + '\'' +
                '}';
    }
}

