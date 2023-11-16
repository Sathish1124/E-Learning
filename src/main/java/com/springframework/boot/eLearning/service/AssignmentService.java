package com.springframework.boot.eLearning.service;

import com.springframework.boot.eLearning.entity.Assignment;
import org.springframework.http.ResponseEntity;

public interface AssignmentService {
    ResponseEntity<String> submitAssignment(Long studentId, Assignment assignment);
}
