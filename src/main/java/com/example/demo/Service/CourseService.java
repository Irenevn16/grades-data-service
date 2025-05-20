package com.example.demo.Service;

import com.example.demo.DTO.CourseGradeDto;
import com.example.demo.Repository.CourseRepository;
import com.example.demo.Repository.GradeRepository;
import com.example.demo.model.Course;
import com.example.demo.model.Grade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private GradeRepository gradeRepository;

    public ResponseEntity<?> findByCourseCode(String courseCode){
        Optional<Course> course = courseRepository.findByCourseCode(courseCode);
        if(course.isPresent()) {
            Course response = course.get();
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}
