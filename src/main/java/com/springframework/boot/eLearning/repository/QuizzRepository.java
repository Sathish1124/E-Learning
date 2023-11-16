package com.springframework.boot.eLearning.repository;

import com.springframework.boot.eLearning.entity.Quizz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizzRepository extends JpaRepository<Quizz, Long> {
}
