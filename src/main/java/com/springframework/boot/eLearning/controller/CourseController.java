package com.springframework.boot.eLearning.controller;

import com.springframework.boot.eLearning.entity.Course;
import com.springframework.boot.eLearning.service.CourseService;
import com.springframework.boot.eLearning.service.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping("/api/courses")
    public ResponseEntity<String> saveCourse(@RequestBody Course course){

            return courseService.saveCourse(course);
    }

    @GetMapping("api/courses")
    public List<Course> fetchCourse(){
            return courseService.fetchCourse();

    }

    @GetMapping("api/getcourses")
    //public List<Course> fetchCourse()
    public ResponseEntity<List<Course>> getAllCourses(){
        return courseService.getAllCourses();

    }

}

