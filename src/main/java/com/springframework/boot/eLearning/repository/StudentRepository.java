package com.springframework.boot.eLearning.repository;

import com.springframework.boot.eLearning.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

    @Query(value = "select s.student_id,s.student_name,s.assignment_progress,s.quiz_progress from student s where s.student_id=?1",
            nativeQuery = true)
    List<Student> getStudentProgress(Long studentId);
}
