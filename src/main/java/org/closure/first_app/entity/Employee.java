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
    @JsonIgnore
    Integer id;
    String salary;
    @Column(name = "working_hours")
    int workingHours;

    @OneToOne(optional = false,targetEntity = User.class)
    User user;
}
