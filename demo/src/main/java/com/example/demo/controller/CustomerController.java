package com.example.demo.controller;


import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("/get")
    public List<Customer> getAllCustomer()
    {
        return customerRepository.findAll();
    }

    @PostMapping("/post")
    public Customer createCustomer(@RequestBody Customer customer)
    {
        return customerRepository.save(customer);
    }

    @PutMapping("/put/{id}")
    public ResponseEntity<Customer> updateCustom(@PathVariable Long id, @RequestBody Customer customerdetail) throws Exception {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new Exception("Customer not exist with id :" + id));   //nem vao exception

        customer.setId(customerdetail.getId());
        customer.setUsername(customerdetail.getUsername());
        customer.setPassword(customerdetail.getPassword());
        customer.setEmail(customerdetail.getEmail());

        Customer updatedEmployee = customerRepository.save(customer);
        return ResponseEntity.ok(updatedEmployee);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteEmployee(@PathVariable Long id) throws Exception {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new Exception("Employee not exist with id :" + id));

        customerRepository.delete(customer);

    }

}






















//        Map<String, Boolean> response = new HashMap<>();    <Map<String, Boolean>>
//        response.put("deleted", Boolean.TRUE);
//        return ResponseEntity.ok(response);
