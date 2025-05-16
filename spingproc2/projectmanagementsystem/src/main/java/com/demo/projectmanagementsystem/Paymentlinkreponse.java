package com.demo.projectmanagementsystem;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Paymentlinkreponse
{

    private  String payment_link_url;
    private String Payment_link_id;

}
