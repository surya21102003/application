package com.example.demo.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String fullname;
    private String email;
    private String password;
    private  USER_ROLE role;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "customer")
    private List<Order> orders=new ArrayList<>();

    @ElementCollection
    private List<RestaurantDto> favorites=new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Address> addresses =new ArrayList<>();

    public List<RestaurantDto> getFavorites() {
        return favorites;
    }

    public void setFavorites(List<RestaurantDto> favorites) {
        this.favorites = favorites;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public USER_ROLE getRole() {
        return role;
    }

    public void setRole(USER_ROLE role) {
        this.role = role;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }
}
