package com.javatechie.jpa.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)//
@JsonInclude(JsonInclude.Include.NON_DEFAULT)//If I dont want to see the default values ie null or zero or etc of variables of this class
public class OrderResponse {

    //Customer Class Variables
    private int id;
    private String name;
    private String email;
    private String gender;


    //Product class variables
    private int pid;
    private String productName;
    private int qty;
    private int price;


    //Constructors based on @Query in CustomerRepository

    //Constructor to show name from Customer and productName from product class
    public OrderResponse(String name, String productName) {
        this.name = name;
        this.productName = productName;
    }


    //Constructor to show email from Customer class and price from product class


    public OrderResponse(String email, int price) {
        this.email = email;
        this.price = price;
    }
}
