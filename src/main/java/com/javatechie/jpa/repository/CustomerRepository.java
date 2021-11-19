package com.javatechie.jpa.repository;

import com.javatechie.jpa.dto.OrderResponse;
import com.javatechie.jpa.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
//this query is jpa query not related to sql
    //in sql it is select customer.name, product.product_name from Customer inner join Product on customer.id=product.cp_fk;

//@Query("SELECT c.name, p.productName FROM Customer c JOIN c.products p")   but in order to make know JPA that above
    //2 fields name and productName are needed to be mapped with OrderResponse we hv define like below
    //make new OrderResponse object and inside its constructors pass name & productName
    //using join query 2 fields name & productName will be fetched and will be mapped to our OrderRespnse object
//JPA QUERY
@Query("SELECT new com.javatechie.jpa.dto.OrderResponse(c.name, p.productName) FROM Customer c JOIN c.products p")
    public List<OrderResponse> getJoinInformation();//for this we hv created OrderResponse class to hold the out
    //of this method

    @Query("SELECT new com.javatechie.jpa.dto.OrderResponse(c.email,p.price) FROM Customer as c JOIN c.products as p")
    List<OrderResponse> getEmailPrice();

}

//WARNING IN JPA QUERY
//US CLASS NAME NOT TABLE NAME
//AND VARIABLE NAMES NOT COLUMN NAMES OF TABLE
