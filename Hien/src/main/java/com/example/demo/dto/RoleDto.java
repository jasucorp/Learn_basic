package com.example.demo.dto;

import com.example.demo.model.Role;
import com.example.demo.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor

public class RoleDto {
    private Long id;

    private String name;

    private String description;

    private List<User> user;

    public RoleDto(Role role) {
        id = role.getId();
        name = role.getName();

    }
}
