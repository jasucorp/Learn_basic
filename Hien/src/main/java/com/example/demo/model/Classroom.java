package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;
import java.util.UUID;

@Data
@AllArgsConstructor
@Entity
@Table(name = "classroom")
public class Classroom {
    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

//    @ManyToOne
//    @JoinColumn(name = "subject_id")
//    private Subject subject;

    @Column(name = "create_date")
    private Date createDate;

    @Column(name = "name_subject")
    private String namesubject;

    @Column(name = "grade")
    private Integer grade;

    @Column(name = "schedule")
    private String schedules;

//    @OneToMany(mappedBy = "classroom" )
//    private Set<ClassroomSchedule> schedules;

    @Column(name = "gender")
    private String gender;

    @Column(name = "max_number")
    private Integer maxnumber;

    @Column(name = "current_number")
    private Integer current_number;

    @Column(name = "type")
    private String type;

    @Column(name = "id_usercreat")
    private Long id_usercreat;

    @Column(name = "phone")
    private String phoneNumber;

//    @OneToOne
//    @JoinColumn(name = "address_id", nullable = true)
//    private Address address;


    @Column(name = "fee")
    private double fee;

    @Column(name = "note")
    private String note;

    public Classroom(){
        createDate = new Date();
    }
}
