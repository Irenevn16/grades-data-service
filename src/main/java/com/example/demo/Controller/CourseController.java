package com.example.demo.Controller;

import com.example.demo.Service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/course")
public class CourseController {
    //buscar por coursecode-endpoint
    @Autowired
    private CourseService courseService;

    @GetMapping("/{courseCode}")
    @ResponseStatus(HttpStatus.FOUND)
    public ResponseEntity<?> getByCourseCode (@PathVariable String courseCode){
        return courseService.findByCourseCode(courseCode);
    }
}
