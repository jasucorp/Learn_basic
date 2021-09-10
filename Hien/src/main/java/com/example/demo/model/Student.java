package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "student")
public class Student {
    @Id
    @Column(name = "idStudent")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "knowledge")
    private String knowledge;

    @Column(name = "school")
    private String school;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;
}
