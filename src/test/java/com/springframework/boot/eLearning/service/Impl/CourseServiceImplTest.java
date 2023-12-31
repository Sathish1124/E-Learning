package com.springframework.boot.eLearning.service.Impl;

import com.springframework.boot.eLearning.entity.Course;
import com.springframework.boot.eLearning.repository.CourseRepository;
import com.springframework.boot.eLearning.service.CourseService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.BDDAssumptions.given;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
class CourseServiceImplTest {

    //@Autowired
    //CourseService courseService;

    @InjectMocks
    private CourseServiceImpl courseService;
    @Mock
    private CourseRepository courseRepository;

    private Course course;
    @BeforeEach
    void setUp() {
        course = Course.builder()
                        .courseId(1L)
                        .courseName("Java")
                        .build();
    }
    @Test
    public void saveCourse()
    {

        when(courseRepository.save(course)).thenReturn(course);
        System.out.println(courseRepository);
        System.out.println(courseService);


        ResponseEntity<String> savedCourse = courseService.saveCourse(course);

        System.out.println(savedCourse);

        assertThat(savedCourse).isNotNull();
    }

    @Test
    void fetchCourse() {

        Course course1 = Course.builder()
                    .courseId(2L)
                    .courseName("Python")
                    .build();

        //given(courseRepository.findAll()).willReturn(List.of(course,course1));
        when(courseRepository.findAll()).thenReturn(List.of(course,course1));

        List<Course> courseList = courseService.fetchCourse();

        assertThat(courseList).isNotNull();
        assertThat(courseList.size()).isEqualTo(2);
    }


}
