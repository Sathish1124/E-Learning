package com.springframework.boot.eLearning.repository;

import com.springframework.boot.eLearning.entity.Modules;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModulesRepository extends JpaRepository<Modules,Long> {
}
