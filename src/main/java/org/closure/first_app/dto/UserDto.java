package org.closure.first_app.dto;

import java.util.Date;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import org.closure.first_app.model.EmployeeModel;

public class UserDto {
    Integer id;
    String name;
    String email;
    String password;
    Date createAt;
    @JsonInclude(value = Include.NON_NULL)
    EmployeeModel employee; 

    public UserDto() {
    }

    public UserDto(Integer id, String name, String email, String password, Date createAt, EmployeeModel employee) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.createAt = createAt;
        this.employee = employee;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreateAt() {
        return this.createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public EmployeeModel getEmployee() {
        return this.employee;
    }

    public void setEmployee(EmployeeModel employee) {
        this.employee = employee;
    }

    public UserDto id(Integer id) {
        setId(id);
        return this;
    }

    public UserDto name(String name) {
        setName(name);
        return this;
    }

    public UserDto email(String email) {
        setEmail(email);
        return this;
    }

    public UserDto password(String password) {
        setPassword(password);
        return this;
    }

    public UserDto createAt(Date createAt) {
        setCreateAt(createAt);
        return this;
    }

    public UserDto employee(EmployeeModel employee) {
        setEmployee(employee);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof UserDto)) {
            return false;
        }
        UserDto userDto = (UserDto) o;
        return Objects.equals(id, userDto.id) && Objects.equals(name, userDto.name) && Objects.equals(email, userDto.email) && Objects.equals(password, userDto.password) && Objects.equals(createAt, userDto.createAt) && Objects.equals(employee, userDto.employee);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, password, createAt, employee);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", name='" + getName() + "'" +
            ", email='" + getEmail() + "'" +
            ", password='" + getPassword() + "'" +
            ", createAt='" + getCreateAt() + "'" +
            ", employee='" + getEmployee() + "'" +
            "}";
    }

}
