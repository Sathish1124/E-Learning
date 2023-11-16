package com.springframework.boot.eLearning.controller;

import com.springframework.boot.eLearning.entity.Student;
import com.springframework.boot.eLearning.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/api/enrollments")
    public ResponseEntity<String> enrollStudent(@RequestBody Student student) {

        return studentService.enrollStudent(student);

    }

    @GetMapping("/api/progress")
    public List<Student> getProgress() {
        return studentService.getProgress();

    }

    @GetMapping("/api/{studentId}/progress")
    public List<Student> getStudentProgress(@PathVariable Long studentId) {
        return studentService.getStudentProgress(studentId);

    }

}
