package com.springframework.boot.eLearning.controller;

import com.springframework.boot.eLearning.entity.Assignment;
import com.springframework.boot.eLearning.entity.Quizz;
import com.springframework.boot.eLearning.entity.Student;
import com.springframework.boot.eLearning.service.AssignmentService;
import com.springframework.boot.eLearning.service.QuizzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskController {
    @Autowired
    private AssignmentService assignmentService;

    @Autowired
    private QuizzService quizzService;

    @PostMapping("/api/{studentId}/quizzes")
    public ResponseEntity<String> submitQuizz(@PathVariable Long studentId, @RequestBody Quizz quizz){

        return quizzService.submitQuizz(studentId,quizz);

    }

    @PostMapping("/api/{studentId}/assignments")
    public ResponseEntity<String> submitAssignment(@PathVariable Long studentId, @RequestBody Assignment assignment){

        return assignmentService.submitAssignment(studentId,assignment);
    }


}
