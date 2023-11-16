package com.springframework.boot.eLearning.service.Impl;

import com.springframework.boot.eLearning.entity.Assignment;
import com.springframework.boot.eLearning.entity.Student;
import com.springframework.boot.eLearning.repository.AssignmentRepository;
import com.springframework.boot.eLearning.repository.StudentRepository;
import com.springframework.boot.eLearning.service.AssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AssignmentServiceImpl implements AssignmentService {

    @Autowired
    private AssignmentRepository assignmentRepository;
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public ResponseEntity<String> submitAssignment(Long studentId, Assignment assignment) {
        Optional<Student> optionalStudent = studentRepository.findById(studentId);
        if (optionalStudent.isPresent()) {
            Student student = optionalStudent.get();
            assignment.setSd(student);
            student.setAssignmentProgress(student.getAssignmentProgress()+1);
            assignmentRepository.save(assignment);

            return ResponseEntity.ok("Assignment submitted successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
