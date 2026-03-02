package com.froyo.service.model.dto;

import com.froyo.messages.AbstractResponse;
import java.util.Objects;

public class CurrencyResponse extends AbstractResponse {

    private static final long serialVersionUID = 3141555321954313455L;
    private CurrencyRequest currencyRequest = new CurrencyRequest();

    public CurrencyRequest getCurrencyRequest() {
        return currencyRequest;
    }

    public void setCurrencyRequest(CurrencyRequest currencyRequest) {
        this.currencyRequest = currencyRequest;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        if (!super.equals(o))
            return false;
        CurrencyResponse that = (CurrencyResponse) o;
        return Objects.equals(currencyRequest, that.currencyRequest);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), currencyRequest);
    }

    @Override
    public String toString() {
        return "CurrencyResponse{" +
                "currencyRequest=" + currencyRequest +
                "} " + super.toString();
    }
}
