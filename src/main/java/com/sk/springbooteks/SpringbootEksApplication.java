package com.sk.springbooteks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLOutput;
import java.util.List;
import java.util.Objects;

@SpringBootApplication
@RestController
public class SpringbootEksApplication {

    @Autowired
    private CustomerRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(SpringbootEksApplication.class, args);
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello World";
    }

    @GetMapping("/greeting/{user}")
    public String greeting(@PathVariable String user) {
        return "Hello " + user;
    }

    @GetMapping("/api/customers")
    public ResponseEntity<List<Customer>> getAllCustomers(){
        List<Customer> customerList = repository.findAll();

        if (customerList!= null){
            customerList.forEach(customer -> System.out.println(" Customer record " + customer));
        }
        return ResponseEntity.ok(customerList);
    }

    @PostMapping("/api/customers")
    public ResponseEntity<Customer> createNewCustomer(@RequestBody Customer customer){
        Customer customer1 = repository.save(customer);
        return ResponseEntity.ok(customer1);
    }
}
