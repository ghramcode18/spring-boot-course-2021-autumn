package org.closure.first_app.dto;

import java.util.Objects;

import org.closure.first_app.model.UserModel;

public class EmployeeDto {
    Integer id;
    String salary;
    int workingHours;
    UserModel user;

    public EmployeeDto() {
    }

    public EmployeeDto(Integer id, String salary, int workingHours, UserModel user) {
        this.id = id;
        this.salary = salary;
        this.workingHours = workingHours;
        this.user = user;
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

    public UserModel getUser() {
        return this.user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }

    public EmployeeDto id(Integer id) {
        setId(id);
        return this;
    }

    public EmployeeDto salary(String salary) {
        setSalary(salary);
        return this;
    }

    public EmployeeDto workingHours(int workingHours) {
        setWorkingHours(workingHours);
        return this;
    }

    public EmployeeDto user(UserModel user) {
        setUser(user);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof EmployeeDto)) {
            return false;
        }
        EmployeeDto employeeDto = (EmployeeDto) o;
        return Objects.equals(id, employeeDto.id) && Objects.equals(salary, employeeDto.salary) && workingHours == employeeDto.workingHours && Objects.equals(user, employeeDto.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, salary, workingHours, user);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", salary='" + getSalary() + "'" +
            ", workingHours='" + getWorkingHours() + "'" +
            ", user='" + getUser() + "'" +
            "}";
    }


}
