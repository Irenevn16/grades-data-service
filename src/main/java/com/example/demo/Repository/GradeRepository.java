package com.example.demo.Repository;

import com.example.demo.model.Course;
import com.example.demo.model.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GradeRepository extends JpaRepository <Grade, Long> {
    public List<Grade> findByCourse (Course course);
}
