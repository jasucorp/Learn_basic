package com.example.demo.dto;

import com.example.demo.model.Achivement;
import com.example.demo.model.Tutor;
import com.example.demo.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TutorDto {
    private Long id;

    private String knowledge;

    private String school;

    private int experience;

    private List<AchivementDto> achivement;

    private String subjectname;

    private UserDto user;

    public TutorDto(Tutor entity){
        id = entity.getId();
        knowledge = entity.getKnowledge();
        school = entity.getSchool();
        experience = entity.getExperience();
        subjectname = entity.getSubjectname();

        if(entity.getUser() != null){
            user = new UserDto(entity.getUser(), true);
        }

        if(entity.getAchivement() != null){
            achivement = entity.getAchivement()
                    .parallelStream()
                    .map(item -> new AchivementDto(item, true))
                    .collect(Collectors.toList());
        }
    }

    public TutorDto(Tutor entity, boolean simple){
        id = entity.getId();
        knowledge = entity.getKnowledge();
        school = entity.getSchool();
        experience = entity.getExperience();
        subjectname = entity.getSubjectname();

        if(entity.getUser() != null){
            user = new UserDto(entity.getUser(), true);
        }

        if(entity.getAchivement() != null){
            achivement = entity.getAchivement()
                    .parallelStream()
                    .map(item -> new AchivementDto(item, true))
                    .collect(Collectors.toList());
        }
    }
}
