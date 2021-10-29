package org.closure.first_app.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue
    Integer id;
    String name;
    String serialNumber;
    double price;

    @ManyToMany(mappedBy = "items")
    List<User> purchasers = new ArrayList<>();



    public Product() {
    }

    public Product(Integer id, String name, String serialNumber, double price, List<User> purchasers) {
        this.id = id;
        this.name = name;
        this.serialNumber = serialNumber;
        this.price = price;
        this.purchasers = purchasers;
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

    public String getSerialNumber() {
        return this.serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<User> getPurchasers() {
        return this.purchasers;
    }

    public void setPurchasers(List<User> purchasers) {
        this.purchasers = purchasers;
    }

    public Product id(Integer id) {
        setId(id);
        return this;
    }

    public Product name(String name) {
        setName(name);
        return this;
    }

    public Product serialNumber(String serialNumber) {
        setSerialNumber(serialNumber);
        return this;
    }

    public Product price(double price) {
        setPrice(price);
        return this;
    }

    public Product purchasers(List<User> purchasers) {
        setPurchasers(purchasers);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Product)) {
            return false;
        }
        Product product = (Product) o;
        return Objects.equals(id, product.id) && Objects.equals(name, product.name) && Objects.equals(serialNumber, product.serialNumber) && price == product.price && Objects.equals(purchasers, product.purchasers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, serialNumber, price, purchasers);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", name='" + getName() + "'" +
            ", serialNumber='" + getSerialNumber() + "'" +
            ", price='" + getPrice() + "'" +
            ", purchasers='" + getPurchasers() + "'" +
            "}";
    }


}
