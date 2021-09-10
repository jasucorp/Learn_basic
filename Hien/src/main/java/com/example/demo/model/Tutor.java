package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tutor")
public class Tutor {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "knowledge")
    private String knowledge;

    @Column(name = "school")
    private String school;

    @Column(name = "experience", nullable = false)
    private int experience;

    @OneToMany(mappedBy = "tutor", cascade = CascadeType.ALL)
    private List<Achivement> achivement;

    @Column(name = "subjectname", nullable = false)
    private String subjectname;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}
