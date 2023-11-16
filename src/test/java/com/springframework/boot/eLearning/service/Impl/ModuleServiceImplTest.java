package com.springframework.boot.eLearning.service.Impl;

import com.springframework.boot.eLearning.entity.Course;
import com.springframework.boot.eLearning.entity.Modules;
import com.springframework.boot.eLearning.entity.Student;
import com.springframework.boot.eLearning.repository.CourseRepository;
import com.springframework.boot.eLearning.repository.ModulesRepository;
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
class ModuleServiceImplTest {

    @Mock
    ModulesRepository modulesRepository;
    @Mock
    CourseRepository courseRepository;
    @InjectMocks
    ModuleServiceImpl moduleService;

    private Modules modules;
    private Course course;

    @BeforeEach
    void setUp() {
        course = Course.builder()
                .courseId(1L)
                .courseName("Java")
                .build();
        modules=Modules.builder()
                    .id(1L)
                    .moduleTitle("Streams Api")
                    .cd(course)
                    .build();
    }

    @Test
    void saveModule() {

        when(modulesRepository.save(modules)).thenReturn(modules);

        ResponseEntity<Modules> savedModule = moduleService.saveModule(course.getCourseId(), modules);
        assertThat(savedModule).isNotNull();
    }
}