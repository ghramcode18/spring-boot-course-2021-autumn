package org.closure.first_app.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue
    Integer id;

    String name;
    @Column(unique = true)
    String email;
    String password;
    @Column(name = "created_at",updatable = false)
    Date createAt;

}
