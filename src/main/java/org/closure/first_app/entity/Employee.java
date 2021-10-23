package org.closure.first_app.entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@JsonInclude(value = Include.NON_NULL)
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue
    Integer id;
    String salary;
    @Column(name = "working_hours")
    int workingHours;

    @OneToOne(optional = false,targetEntity = User.class)
    User user;

    public Employee() {
    }

    public Employee(Integer id, String salary, int workingHours, User user) {
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

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Employee id(Integer id) {
        setId(id);
        return this;
    }

    public Employee salary(String salary) {
        setSalary(salary);
        return this;
    }

    public Employee workingHours(int workingHours) {
        setWorkingHours(workingHours);
        return this;
    }

    public Employee user(User user) {
        setUser(user);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Employee)) {
            return false;
        }
        Employee employee = (Employee) o;
        return Objects.equals(id, employee.id) && Objects.equals(salary, employee.salary) && workingHours == employee.workingHours && Objects.equals(user, employee.user);
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
