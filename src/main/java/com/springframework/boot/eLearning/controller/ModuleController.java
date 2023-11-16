package com.springframework.boot.eLearning.controller;

import com.springframework.boot.eLearning.entity.Course;
import com.springframework.boot.eLearning.entity.Modules;
import com.springframework.boot.eLearning.service.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ModuleController {

    @Autowired
    private ModuleService moduleService;

    @PostMapping("/api/courses/{courseId}/modules")
    public ResponseEntity<Modules> saveModule(@PathVariable("courseId") Long coursesId, @RequestBody Modules modules){
        return moduleService.saveModule(coursesId,modules);
    }
}
