package com.froyo.model;

import java.util.Objects;

public class EmployeeAddress {

    private String houseNo;
    private String streetNo;
    private String zipCode;

    public String getHouseNo() {
        return houseNo;
    }

    public void setHouseNo(String houseNo) {
        this.houseNo = houseNo;
    }

    public String getStreetNo() {
        return streetNo;
    }

    public void setStreetNo(String streetNo) {
        this.streetNo = streetNo;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        EmployeeAddress that = (EmployeeAddress) o;
        return Objects.equals(houseNo, that.houseNo) && Objects.equals(streetNo, that.streetNo)
                && Objects.equals(zipCode, that.zipCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(houseNo, streetNo, zipCode);
    }

    @Override
    public String toString() {
        return "EmployeeAddress{" +
                "houseNo='" + houseNo + '\'' +
                ", streetNo='" + streetNo + '\'' +
                ", zipCode='" + zipCode + '\'' +
                '}';
    }
}
