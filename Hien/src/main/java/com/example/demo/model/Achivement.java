package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "achivement")
public class Achivement implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

//    @Column(name = "id_tutor")
//    private Long id_tutor;

    @Column(name = "achivement")
    private String achivement;

    @Column(name = "year")
    private Integer year;

    @ManyToOne
    @JoinColumn(name = "id_tutor",referencedColumnName = "id")
    private Tutor tutor;

}
