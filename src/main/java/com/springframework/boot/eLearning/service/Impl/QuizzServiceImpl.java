package com.springframework.boot.eLearning.service.Impl;

import com.springframework.boot.eLearning.entity.Quizz;
import com.springframework.boot.eLearning.entity.Student;
import com.springframework.boot.eLearning.repository.AssignmentRepository;
import com.springframework.boot.eLearning.repository.QuizzRepository;
import com.springframework.boot.eLearning.repository.StudentRepository;
import com.springframework.boot.eLearning.service.QuizzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class QuizzServiceImpl implements QuizzService {

    @Autowired
    private QuizzRepository quizzRepository;

    @Autowired
    private StudentRepository studentRepository;
    @Override
    public ResponseEntity<String> submitQuizz(Long studentId, Quizz quizz) {

        Optional<Student> optionalStudent = studentRepository.findById(studentId);
        if (optionalStudent.isPresent()) {
            Student student = optionalStudent.get();
            quizz.setStd(student);
            student.setQuizProgress(student.getQuizProgress()+1);
            quizzRepository.save(quizz);

            return ResponseEntity.ok("Quizzes submitted successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
