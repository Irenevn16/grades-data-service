package com.example.demo.Repository;

import com.example.demo.model.Course;
import com.example.demo.model.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CourseRepository extends JpaRepository<Course, String> {
    public Optional<Course> findByCourseCode (String courseCode);

}
