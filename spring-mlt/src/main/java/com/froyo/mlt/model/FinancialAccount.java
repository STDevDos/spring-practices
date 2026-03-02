package com.froyo.mlt.model;

import jakarta.persistence.*;

@Entity
@Table(name = "accounts")
public class FinancialAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double balance;

    /**
     * Jonathan implements optimistic locking with @Version column.
     * This helps prevent data inconsistencies and balance discrepancies
     * when multiple users process transactions concurrently.
     */
    @Version
    private Integer version;

    public FinancialAccount() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}

