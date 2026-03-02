package com.froyo.model;

import java.util.List;
import java.util.Objects;

public class EmployeeNames {

    private List<EmployeeName> employeeNameList;

    public List<EmployeeName> getEmployeeNameList() {
        return employeeNameList;
    }

    public void setEmployeeNameList(List<EmployeeName> employeeNameList) {
        this.employeeNameList = employeeNameList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        EmployeeNames that = (EmployeeNames) o;
        return Objects.equals(employeeNameList, that.employeeNameList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeNameList);
    }

    @Override
    public String toString() {
        return "EmployeeNames{" +
                "employeeNameList=" + employeeNameList +
                '}';
    }
}
