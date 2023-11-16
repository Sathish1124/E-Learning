package com.springframework.boot.eLearning.service.Impl;

import com.springframework.boot.eLearning.entity.Course;
import com.springframework.boot.eLearning.entity.Modules;
import com.springframework.boot.eLearning.repository.CourseRepository;
import com.springframework.boot.eLearning.repository.ModulesRepository;
import com.springframework.boot.eLearning.service.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ModuleServiceImpl implements ModuleService {

    @Autowired
    private ModulesRepository modulesRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public ResponseEntity<Modules> saveModule(Long coursesId, Modules modules) {

        Optional<Course> optionalCourse = courseRepository.findById(coursesId);
        if (optionalCourse.isPresent()){
            Course course=optionalCourse.get();
            modules.setCd(course);

            return ResponseEntity.status(HttpStatus.CREATED).body(modulesRepository.save(modules));

        }

        else {
            return ResponseEntity.notFound().build();
        }

    }
}

//{
//        Optional<Course> optionalCourse = courseRepository.findById(courseId);
//
//        if (optionalCourse.isPresent()) {
//        Course course = optionalCourse.get();
//        subCourse.setParentCourse(course);
//        SubCourse savedSubCourse = subCourseRepository.save(subCourse);
//        return ResponseEntity.status(HttpStatus.CREATED).body(savedSubCourse);
//        }
//        else {
//        return ResponseEntity.notFound().build();
//        }