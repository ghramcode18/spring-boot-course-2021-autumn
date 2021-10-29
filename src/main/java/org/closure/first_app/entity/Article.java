package org.closure.first_app.entity;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "article")
public class Article {

    @Id
    @GeneratedValue
    Integer id;
    String title;
    @Column(updatable = false,name = "created_at")
    Date createdAt;
    String content;
    
    @ManyToOne(targetEntity = User.class)
    User writer;


    
}
