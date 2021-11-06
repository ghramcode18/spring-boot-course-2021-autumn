package org.closure.first_app.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.With;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@With
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue
    Integer id;
    String name;
    Integer phone;
    double bill;
    String password;
   
    @ManyToMany
    @JoinTable(name = "user_meals",joinColumns = {@JoinColumn(name = "uid")},inverseJoinColumns = {@JoinColumn(name = "mid")})
    List<Meal> meals = new ArrayList<>();

    @ManyToOne
    Waiter waiter;


}
