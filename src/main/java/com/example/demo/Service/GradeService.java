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

import java.util.List;
import java.util.Optional;

@Service
public class GradeService {
    @Autowired
    private GradeRepository gradeRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private RestTemplate restTemplate;

    public List<Grade> getAllGrades(){
        return gradeRepository.findAll();
    }

    //esperar al tercer servicio
    public ResponseEntity<?> getGradesByCourseCode (String courseCode) {

        Optional<Course> courseOptional = courseRepository.findByCourseCode(courseCode);

        if(courseOptional.isPresent()) {
            Course course = courseOptional.get();
            List<Grade> grades = gradeRepository.findByCourse(course);
            return new ResponseEntity<>(grades, HttpStatus.OK);

        } else {
            return new ResponseEntity<>("Course not found",HttpStatus.NOT_FOUND);
        }
    }


}
