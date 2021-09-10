package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "subject")
public class Subject {
    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

//    @Column(name = "name")
//    private String name;
//
//    @Column(name = "grade")
//    private Integer grade;
//
//    @OneToMany(mappedBy = "subject")
//    private Set<Classroom> classroom;
}
