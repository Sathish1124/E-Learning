package com.springframework.boot.eLearning.service.Impl;

import com.springframework.boot.eLearning.entity.Assignment;
import com.springframework.boot.eLearning.entity.Quizz;
import com.springframework.boot.eLearning.entity.Student;
import com.springframework.boot.eLearning.repository.AssignmentRepository;
import com.springframework.boot.eLearning.repository.QuizzRepository;
import com.springframework.boot.eLearning.repository.StudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class AssignmentServiceImplTest {

    @Mock
    private AssignmentRepository assignmentRepository;
    @Mock
    private StudentRepository studentRepository;
    @InjectMocks
    private AssignmentServiceImpl assignmentService;

    private Assignment assignment;
    private Student student;

    @BeforeEach
    void setUp() {
        student = Student.builder()
                .studentId(1L)
                .studentName("Sathish")
                .build();
        assignment=Assignment.builder()
                .id(1L)
                .title("Computer Science")
                .assignment("answer")
                .sd(student)
                .build();
    }

    @Test
    void submitAssignment() {
        when(assignmentRepository.save(assignment)).thenReturn(assignment);

        ResponseEntity<String> savedAssign = assignmentService.submitAssignment(student.getStudentId(),assignment);

        assertThat(savedAssign).isNotNull();
    }
}