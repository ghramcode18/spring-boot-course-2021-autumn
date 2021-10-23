package org.closure.first_app.model;

import java.util.Date;
import java.util.Objects;

public class UserModel {
    Integer id;
    String name;
    String email;
    String password;
    Date createAt;

    public UserModel() {
    }

    public UserModel(Integer id, String name, String email, String password, Date createAt) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.createAt = createAt;
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

    public UserModel id(Integer id) {
        setId(id);
        return this;
    }

    public UserModel name(String name) {
        setName(name);
        return this;
    }

    public UserModel email(String email) {
        setEmail(email);
        return this;
    }

    public UserModel password(String password) {
        setPassword(password);
        return this;
    }

    public UserModel createAt(Date createAt) {
        setCreateAt(createAt);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof UserModel)) {
            return false;
        }
        UserModel userModel = (UserModel) o;
        return Objects.equals(id, userModel.id) && Objects.equals(name, userModel.name) && Objects.equals(email, userModel.email) && Objects.equals(password, userModel.password) && Objects.equals(createAt, userModel.createAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, password, createAt);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", name='" + getName() + "'" +
            ", email='" + getEmail() + "'" +
            ", password='" + getPassword() + "'" +
            ", createAt='" + getCreateAt() + "'" +
            "}";
    }

}
