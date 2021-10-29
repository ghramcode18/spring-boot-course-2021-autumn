package org.closure.first_app.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue
    Integer id;
    String name;
    String email;
    String password;

    @OneToMany(mappedBy = "writer")
    List<Article> articles = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "purchasers_and_products", joinColumns = { @JoinColumn(name = "uid") }, inverseJoinColumns = {
            @JoinColumn(name = "pid") })
    List<Product> items = new ArrayList<>();

    public User() {
    }

    public User(Integer id, String name, String email, String password, List<Article> articles, List<Product> items) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.articles = articles;
        this.items = items;
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

    public List<Article> getArticles() {
        return this.articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    public List<Product> getItems() {
        return this.items;
    }

    public void setItems(List<Product> items) {
        this.items = items;
    }

    public User id(Integer id) {
        setId(id);
        return this;
    }

    public User name(String name) {
        setName(name);
        return this;
    }

    public User email(String email) {
        setEmail(email);
        return this;
    }

    public User password(String password) {
        setPassword(password);
        return this;
    }

    public User articles(List<Article> articles) {
        setArticles(articles);
        return this;
    }

    public User items(List<Product> items) {
        setItems(items);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof User)) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(name, user.name) && Objects.equals(email, user.email)
                && Objects.equals(password, user.password) && Objects.equals(articles, user.articles)
                && Objects.equals(items, user.items);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, password, articles, items);
    }

    @Override
    public String toString() {
        return "{" + " id='" + getId() + "'" + ", name='" + getName() + "'" + ", email='" + getEmail() + "'"
                + ", password='" + getPassword() + "'" + ", articles='" + getArticles() + "'" + ", items='" + getItems()
                + "'" + "}";
    }

}
