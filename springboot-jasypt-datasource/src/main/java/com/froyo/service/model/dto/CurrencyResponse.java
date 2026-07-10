package com.froyo.service.model.dto;

import com.froyo.messages.AbstractResponse;

public class CurrencyResponse extends AbstractResponse {

    private static final long serialVersionUID = 3141555321954313455L;
    private CurrencyRequest currencyRequest;

    public CurrencyRequest getCurrencyRequest() {
        return currencyRequest;
    }

    public void setCurrencyRequest(CurrencyRequest currencyRequest) {
        this.currencyRequest = currencyRequest;
    }

    @Override
    public String toString() {
        return "CurrencyResponse{" +
                "currencyRequest=" + currencyRequest +
                "} " + super.toString();
    }
}
