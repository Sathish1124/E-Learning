package com.springframework.boot.eLearning.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Modules {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String moduleTitle;
    @JsonBackReference
    @ManyToOne
    private Course cd;
}
