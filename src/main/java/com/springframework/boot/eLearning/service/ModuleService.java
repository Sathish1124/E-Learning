package com.springframework.boot.eLearning.service;

import com.springframework.boot.eLearning.entity.Course;
import com.springframework.boot.eLearning.entity.Modules;
import org.springframework.http.ResponseEntity;

public interface ModuleService {
    ResponseEntity<Modules> saveModule(Long coursesId, Modules modules);
}
