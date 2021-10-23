package org.closure.first_app.model;

import java.util.Objects;

public class EmployeeModel {
    Integer id;
    String salary;
    int workingHours;

    public EmployeeModel() {
    }

    public EmployeeModel(Integer id, String salary, int workingHours) {
        this.id = id;
        this.salary = salary;
        this.workingHours = workingHours;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSalary() {
        return this.salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public int getWorkingHours() {
        return this.workingHours;
    }

    public void setWorkingHours(int workingHours) {
        this.workingHours = workingHours;
    }

    public EmployeeModel id(Integer id) {
        setId(id);
        return this;
    }

    public EmployeeModel salary(String salary) {
        setSalary(salary);
        return this;
    }

    public EmployeeModel workingHours(int workingHours) {
        setWorkingHours(workingHours);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof EmployeeModel)) {
            return false;
        }
        EmployeeModel employeeModel = (EmployeeModel) o;
        return Objects.equals(id, employeeModel.id) && Objects.equals(salary, employeeModel.salary) && workingHours == employeeModel.workingHours;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, salary, workingHours);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", salary='" + getSalary() + "'" +
            ", workingHours='" + getWorkingHours() + "'" +
            "}";
    }

}
