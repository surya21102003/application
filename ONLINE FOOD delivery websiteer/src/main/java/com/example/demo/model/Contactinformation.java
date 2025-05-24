package com.example.demo.model;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Data

public class Contactinformation {
    private String email;
    private String mobile;
    private String twitter;
    private String instagram;


}
