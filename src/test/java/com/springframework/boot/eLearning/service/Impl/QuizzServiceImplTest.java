package com.springframework.boot.eLearning.service.Impl;

import com.springframework.boot.eLearning.entity.Modules;
import com.springframework.boot.eLearning.entity.Quizz;
import com.springframework.boot.eLearning.entity.Student;
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
class QuizzServiceImplTest {

    @Mock
    private QuizzRepository quizzRepository;
    @Mock
    private StudentRepository studentRepository;
    @InjectMocks
    private QuizzServiceImpl quizzService;

    private Quizz quizz;
    private Student student;

    @BeforeEach
    void setUp() {
        student = Student.builder()
                .studentId(1L)
                .studentName("Sathish")
                .build();
        quizz=Quizz.builder()
                .id(1L)
                .question("random question")
                .answer(2)
                .std(student)
                .build();
    }

    @Test
    void submitQuizz() {
        when(quizzRepository.save(quizz)).thenReturn(quizz);

        ResponseEntity<String> savedQuizz = quizzService.submitQuizz(student.getStudentId(),quizz);

        assertThat(savedQuizz).isNotNull();
    }
}