package com.froyo.model;

import java.util.List;
import java.util.Objects;

public class EmployeeAddresses {

    private List<EmployeeAddress> employeeAddressList;

    public List<EmployeeAddress> getEmployeeAddressList() {
        return employeeAddressList;
    }

    public void setEmployeeAddressList(List<EmployeeAddress> employeeAddressList) {
        this.employeeAddressList = employeeAddressList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        EmployeeAddresses that = (EmployeeAddresses) o;
        return Objects.equals(employeeAddressList, that.employeeAddressList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeAddressList);
    }

    @Override
    public String toString() {
        return "EmployeeAddresses{" +
                "employeeAddressList=" + employeeAddressList +
                '}';
    }
}
