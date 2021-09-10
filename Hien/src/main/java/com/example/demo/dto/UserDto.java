package com.example.demo.dto;

import com.example.demo.model.Role;
import com.example.demo.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.math.BigInteger;
import java.text.DateFormat;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private Long id;

    private String username;

    private String email;

    private Date birthday;

    private String gender;

    private String address;

    private String phone;

    private String password;

//    private String repassword;

    private RoleDto role;

    private String knowledge;

    private String school;

    private Integer experience;

    private String achivement;

    private String subjectname;

    private TutorDto tutor;

    public UserDto(User entity){
        id = entity.getId();
        username = entity.getUsername();
        email = entity.getEmail();
        birthday = entity.getBirthday();
        gender = entity.getGender();
        address = entity.getAddress();
        phone = entity.getPhone();
        if(entity.getRole() != null){
            role = new RoleDto(entity.getRole());
        }
        if(entity.getTutor() != null){
            tutor = new TutorDto(entity.getTutor(), true);
        }
    }

    public UserDto(User entity, boolean simple){
        id = entity.getId();
        username = entity.getUsername();
        email = entity.getEmail();
        birthday = entity.getBirthday();
        gender = entity.getGender();
        address = entity.getAddress();
        phone = entity.getPhone();


    }


}
