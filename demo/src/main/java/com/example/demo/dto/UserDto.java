package com.example.demo.dto;

import com.example.demo.model.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {

    private Long id;

    private String username;

    private String email;

    private Date birthday;

    private String gender;

    private String address;

    private int phone;

    private String role;

    private String password;

    public CustomerDto(Customer entity){
        id = entity.getId();
        username = entity.getUsername();
        email = entity.getEmail();
        birthday = entity.getBirthday();
        gender = entity.getGender();
        address = entity.getAddress();
        phone = entity.getPhone();
        role = entity.getRole();
    }
}
