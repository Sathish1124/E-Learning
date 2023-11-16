package com.springframework.boot.eLearning.service.Impl;

import com.springframework.boot.eLearning.entity.Course;
import com.springframework.boot.eLearning.repository.CourseRepository;
import com.springframework.boot.eLearning.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;
    @Override
    public ResponseEntity<String> saveCourse(Course course) {

        courseRepository.save(course);
        return ResponseEntity.ok("Course: "+ course.getCourseName() +
                " created successfully with course Id: " + course.getCourseId());
    }

    @Override
    public List<Course> fetchCourse() {

        return courseRepository.findAll();
    }

    @Override
    public ResponseEntity<List<Course>> getAllCourses() {
        List<Course> courses = courseRepository.findAll();
        return ResponseEntity.ok(courses);
    }

}
