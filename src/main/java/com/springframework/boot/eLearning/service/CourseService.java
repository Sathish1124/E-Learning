package com.springframework.boot.eLearning.service;

import com.springframework.boot.eLearning.entity.Course;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CourseService {
    public ResponseEntity<String> saveCourse(Course course);

    public List<Course> fetchCourse();

    ResponseEntity<List<Course>> getAllCourses();
}
