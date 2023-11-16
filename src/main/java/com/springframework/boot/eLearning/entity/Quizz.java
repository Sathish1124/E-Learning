package com.springframework.boot.eLearning.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
public class Quizz {
        @Id
        @GeneratedValue (strategy = GenerationType.AUTO)
        private Long id;
        private String question;
        private int answer;

        @JsonBackReference
        @ManyToOne
        private Student std;
}

