package com.example.demo.controller;


import com.example.demo.Response;
import com.example.demo.constants.ErrorCodeEnum;
import com.example.demo.dto.CustomerDto;
import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    @Autowired
    private CustomerRepository customerRepository;


    //get list cus
    @GetMapping
    public List<Customer> getAllCustomer()
    {
        return customerRepository.findAll();
//        return customerRepository.findAll()
//                .stream()
//                .parallel()
//                .map(CustomerDto::new)
//                .collect(Collectors.toList());
    }

    //get cus
    @GetMapping("/{id}")
    public Response<CustomerDto> getCustomer(@PathVariable(value = "id") Long id) throws Exception {
        Optional<Customer> customerOptional = customerRepository.findById(id);

        Customer customer = null;
        if(!customerOptional.isPresent()){
            return new Response<>(ErrorCodeEnum.CUSTOMER_NOT_FOUND);
        } else {
            customer = customerOptional.get();
        }

        CustomerDto customerDto = new CustomerDto();

        customerDto.setId(customer.getId());
        customerDto.setUsername(customer.getUsername());
        customerDto.setEmail(customer.getEmail());
        customerDto.setBirthday(customer.getBirthday());
        customerDto.setGender(customer.getGender());
        customerDto.setAddress(customer.getAddress());
        customerDto.setPhone(customer.getPhone());
        customerDto.setRole(customer.getRole());

        return new Response<>(customerDto);
    }

    //creat cus
    @PostMapping
    public Response<CustomerDto> createCustomer(@RequestBody CustomerDto customerDto)
    {
        if(customerDto.getId() != null){
            return new Response<>(ErrorCodeEnum.CREATE_MUST_NOT_HAVE_ID);
        };


        Customer entity = new Customer();
        entity.setId(entity.getId());
        entity.setUsername(entity.getUsername());
        entity.setEmail(entity.getEmail());
        entity.setBirthday(entity.getBirthday());
        entity.setGender(entity.getGender());
        entity.setAddress(entity.getAddress());
        entity.setPhone(entity.getPhone());
        entity.setRole(entity.getRole());


        Customer customer = customerRepository.save(entity);

        return new Response<>(new CustomerDto(entity));
    }

//    @PutMapping("/{id}")
//    public Response<CustomerDto> updateCustom(@PathVariable Long id, @RequestBody CustomerDto customerdetail){
//        Optional<Customer> customerOptional = customerRepository.findById(id);
//
//        Customer customer = null;
//        if(!customerOptional.isPresent()){
//            return new Response<>(ErrorCodeEnum.CUSTOMER_NOT_FOUND);
//        } else {
//            customer = customerOptional.get();
//        }
//
//        if(customerdetail.getUsername() != null && !customerdetail.getUsername().equals(customer.getUsername()))
//            customer.setUsername(customerdetail.getUsername());
//
//        if(customerdetail.getPassword() != null && !customerdetail.getPassword().equals(customer.getPassword()))
//            customer.setPassword(customerdetail.getPassword());
//
//        if(customerdetail.getEmail() != null && !customerdetail.getEmail().equals(customer.getEmail()))
//            customer.setEmail(customerdetail.getEmail());
//
//        Customer entity = customerRepository.save(customer);
//
//        return new Response<>(new CustomerDto(entity));
//    }
//
//    //delete cus
//    @DeleteMapping("/{id}")
//    public Response<CustomerDto> deleteEmployee(@PathVariable Long id){
//        Optional<Customer> customerOptional = customerRepository.findById(id);
//
//        Customer customer = null;
//        if(!customerOptional.isPresent()){
//            return new Response<>(ErrorCodeEnum.CUSTOMER_NOT_FOUND);
//        } else {
//            customer = customerOptional.get();
//           customerRepository.delete(customer);
//
//           return new Response<>(ErrorCodeEnum.DELETE_COMPLETE);
//        }
//
//    }
//
//    //delete all cus
//    @DeleteMapping
//    public Response<CustomerDto> deleteAllEmployee()
//    {
//         customerRepository.deleteAll();
//        return new Response<>(ErrorCodeEnum.DELETE_COMPLETE);
//
//    }



}






















//        Map<String, Boolean> response = new HashMap<>();    <Map<String, Boolean>>
//        response.put("deleted", Boolean.TRUE);
//        return ResponseEntity.ok(response);
