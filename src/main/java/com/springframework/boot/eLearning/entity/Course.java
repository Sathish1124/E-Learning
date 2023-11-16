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
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long courseId;
    private String courseName;
    //private String courseModules;

    @JsonManagedReference
    @OneToMany(mappedBy = "cd", cascade = CascadeType.ALL)
    private List<Modules> modules;
    //private String description;
}
