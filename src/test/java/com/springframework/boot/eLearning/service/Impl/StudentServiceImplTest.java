package com.springframework.boot.eLearning.service.Impl;

import com.springframework.boot.eLearning.entity.Course;
import com.springframework.boot.eLearning.entity.Student;
import com.springframework.boot.eLearning.repository.StudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class StudentServiceImplTest {

    @Mock
    StudentRepository studentRepository;
    @InjectMocks
    StudentServiceImpl studentService;

    private Student student;

    @BeforeEach
    void setUp() {
        student = Student.builder()
                .studentId(1L)
                .studentName("Sathish")
                .assignmentProgress(10)
                .quizProgress(15)
                .build();
    }

    @Test
    void enrollStudent() {

        when(studentRepository.save(student)).thenReturn(student);

        ResponseEntity<String> savedStudent = studentService.enrollStudent(student);

        System.out.println(savedStudent);

        assertThat(savedStudent).isNotNull();
    }

    @Test
    void getProgress() {

        Student student1 = Student.builder()
                .studentId(2L)
                .studentName("Murugan")
                .assignmentProgress(10)
                .quizProgress(5)
                .build();

        when(studentRepository.findAll()).thenReturn(List.of(student,student1));

        List<Student> studentList = studentService.getProgress();


        assertThat(studentList).isNotNull();
        assertThat(studentList.size()).isEqualTo(2);
    }

}