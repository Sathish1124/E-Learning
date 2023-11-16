package com.springframework.boot.eLearning.service;

import com.springframework.boot.eLearning.entity.Quizz;
import org.springframework.http.ResponseEntity;

public interface QuizzService {
    ResponseEntity<String> submitQuizz(Long studentId, Quizz quizz);
}
