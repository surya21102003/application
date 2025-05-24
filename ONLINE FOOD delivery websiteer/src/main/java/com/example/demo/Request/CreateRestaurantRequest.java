package com.example.demo.Request;

import com.example.demo.model.Address;
import com.example.demo.model.Contactinformation;
import lombok.Data;

import java.util.List;

@Data
public class CreateRestaurantRequest {
private Long id;
private String name;
private String cusionType;
private Address address;

private Contactinformation contactinformation;
private String openinghours;
private List<String> images;

    public String getCusionType() {
        return cusionType;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public String getOpeninghours() {
        return openinghours;
    }

    public void setOpeninghours(String openinghours) {
        this.openinghours = openinghours;
    }

    public Contactinformation getContactinformation() {
        return contactinformation;
    }

    public void setContactinformation(Contactinformation contactinformation) {
        this.contactinformation = contactinformation;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setCusionType(String cusionType) {
        this.cusionType = cusionType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

