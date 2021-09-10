package com.example.demo.dto;

import com.example.demo.model.Classroom;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClassroomDto {
    private Long id;

    private String name_subject;

    private Integer grade;

    private String schedules;

    private String gender;

    private Integer max_number;

    private Integer current_number;

    private Date createDate;

    private String type;

    private Long id_usercreat;

    private String phoneNumber;

    private double fee;

    private String note;

    public ClassroomDto(Classroom classroom){
        id = classroom.getId();
        name_subject = classroom.getNamesubject();
        grade = classroom.getGrade();
        schedules = classroom.getSchedules();
        gender = classroom.getGender();
        max_number = classroom.getMaxnumber();
        current_number = classroom.getCurrent_number();
        createDate = new Date();
        type = classroom.getType();
        id_usercreat = classroom.getId_usercreat();
        fee = classroom.getFee();
        note = classroom.getNote();

    }

    public ClassroomDto(Classroom classroom, Boolean simple){
        name_subject = classroom.getNamesubject();
        grade = classroom.getGrade();
        schedules = classroom.getSchedules();
        fee = classroom.getFee();
        note = classroom.getNote();
    }
}
