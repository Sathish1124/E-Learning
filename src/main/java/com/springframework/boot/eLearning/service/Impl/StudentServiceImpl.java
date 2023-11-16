package com.springframework.boot.eLearning.service.Impl;

import com.springframework.boot.eLearning.entity.Student;
import com.springframework.boot.eLearning.repository.StudentRepository;
import com.springframework.boot.eLearning.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public ResponseEntity<String> enrollStudent(Student student) {

        studentRepository.save(student);
        return ResponseEntity.ok("Student: " + student.getStudentName()+ " Enrolled successfully");
    }

//    @Override
//    public List<Student> fetchStudent() {
//
//        return studentRepository.findAll();
//    }

    @Override
    public List<Student> getProgress() {

        return studentRepository.findAll();
    }

    @Override
    public List<Student> getStudentProgress(Long studentId) {
        return studentRepository.getStudentProgress(studentId);
    }



}
