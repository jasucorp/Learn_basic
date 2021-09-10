package com.example.demo.dto;

import com.example.demo.model.Tutor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDto {

    private Long id;

    private String knowledge;

    private String school;

    private UserDto user;

    public StudentDto(Tutor entity){
        id = entity.getId();
        knowledge = entity.getKnowledge();
        school = entity.getSchool();

        if(entity.getUser() != null){
            user = new UserDto(entity.getUser(), true);
        }
    }

    public StudentDto(Tutor entity, boolean simple){
        id = entity.getId();
        knowledge = entity.getKnowledge();
        school = entity.getSchool();
    }
}
