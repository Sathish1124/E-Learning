package com.springframework.boot.eLearning.service;

import com.springframework.boot.eLearning.entity.Student;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface StudentService {

    public ResponseEntity<String> enrollStudent(Student student);

    List<Student> getProgress();

    List<Student> getStudentProgress(Long studentId);

    //List<Student> getStudentProgress();
}
