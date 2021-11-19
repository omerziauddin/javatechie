package com.javatechie.jpa.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Customer {
    @Id
    @GeneratedValue//to auto generate id
    private int id;
    private String name;
    private String email;
    private String gender;
    //One customer can have mutiple products hence one to many relationship

    @OneToMany(targetEntity = Product.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "cp_fk",referencedColumnName = "id")//this will automatically create in product class a column
    // named cp_fk that will act as a foreign key for product class and whose values will be = id column of customer class see info
    private List<Product> products;


}
