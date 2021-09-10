package com.example.demo.model;

import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")
@DynamicUpdate
public class Customer {

    @Id
    @Column(name = "idUser")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "userName")
    private String username;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "birthday")
    private Date birthday;

    @Column(name = "gender")
    private String gender;

    @Column(name = "address")
    private String address;

    @Column(name = "phoneNumber", unique = true)
    private int phone;

    @Column(name = "role")
    private String role;

    @Column(name = "password")
    private String password;

}
