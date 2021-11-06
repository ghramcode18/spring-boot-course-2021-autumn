package org.closure.first_app.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
@Table(name = "type")
public class Type {
    
    @Id
    @GeneratedValue
    Integer id;
    String name;

    @OneToMany(mappedBy = "type")
    List<Meal> meals = new ArrayList<>();
   

    
    
}
