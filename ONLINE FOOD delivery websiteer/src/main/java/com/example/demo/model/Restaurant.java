package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.catalina.LifecycleState;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    private User owner;
    private String name;
    private String description;
    private String cuisinetype;

    @OneToOne
    private Address address ;

    @Embedded
    private Contactinformation contactinformation;

    private String openinghours;

    @OneToMany(mappedBy = "restaurant" ,cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Order> orders=new ArrayList<>();

    @ElementCollection
    @Column(length = 1000)
private List<String> images;

    private LocalDateTime registrationdate;

    private boolean open;

    @JsonIgnore
    @OneToMany(mappedBy = "restaurant" ,cascade = CascadeType.ALL)
    private List<Food> foods=new ArrayList<>();

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCuisinetype() {
        return cuisinetype;
    }

    public void setCuisinetype(String cuisinetype) {
        this.cuisinetype = cuisinetype;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Contactinformation getContactinformation() {
        return contactinformation;
    }

    public void setContactinformation(Contactinformation contactinformation) {
        this.contactinformation = contactinformation;
    }

    public String getOpeninghours() {
        return openinghours;
    }

    public void setOpeninghours(String openinghours) {
        this.openinghours = openinghours;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public LocalDateTime getRegistrationdate() {
        return registrationdate;
    }

    public void setRegistrationdate(LocalDateTime registrationdate) {
        this.registrationdate = registrationdate;
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    public List<Food> getFoods() {
        return foods;
    }

    public void setFoods(List<Food> foods) {
        this.foods = foods;
    }
}
