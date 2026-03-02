package com.froyo.app.model.dto;

import com.froyo.messages.AbstractResponse;
import java.util.Objects;

/**
 * https://stackoverflow.com/questions/38572566/warning-equals-hashcode-on-data-annotation-lombok-with-inheritance
 */
public class CurrencyEntityDTOResponse extends AbstractResponse {

    private static final long serialVersionUID = 3141555321954313455L;
    private CurrencyEntityDTORequest currencyEntityDTORequest = new CurrencyEntityDTORequest();

    public CurrencyEntityDTORequest getCurrencyEntityDTORequest() {
        return currencyEntityDTORequest;
    }

    public void setCurrencyEntityDTORequest(CurrencyEntityDTORequest currencyEntityDTORequest) {
        this.currencyEntityDTORequest = currencyEntityDTORequest;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        if (!super.equals(o))
            return false;
        CurrencyEntityDTOResponse that = (CurrencyEntityDTOResponse) o;
        return Objects.equals(currencyEntityDTORequest, that.currencyEntityDTORequest);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), currencyEntityDTORequest);
    }

    @Override
    public String toString() {
        return "CurrencyEntityDTOResponse{" +
                "currencyEntityDTORequest=" + currencyEntityDTORequest +
                "} " + super.toString();
    }
}
