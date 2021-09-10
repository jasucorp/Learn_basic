package com.example.demo.dto;

import com.example.demo.model.Achivement;
import com.example.demo.model.Tutor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AchivementDto {
    private Long id;

    private String achivement;

    private Integer year;

    private TutorDto tutor;

    public  AchivementDto(Achivement entity, boolean simple){
        id = entity.getId();
        achivement = entity.getAchivement();
        year = entity.getYear();

    }
}
