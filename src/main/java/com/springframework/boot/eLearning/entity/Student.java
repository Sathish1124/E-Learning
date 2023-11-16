package com.springframework.boot.eLearning.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long studentId;
    private String studentName;
    private int quizProgress;
    private int assignmentProgress;

    @JsonManagedReference
    @OneToMany(mappedBy = "std", cascade = CascadeType.ALL)
    private List<Quizz> quizzes;

    @JsonManagedReference
    @OneToMany(mappedBy = "sd", cascade = CascadeType.ALL)
    private List<Assignment> assignments;
}
