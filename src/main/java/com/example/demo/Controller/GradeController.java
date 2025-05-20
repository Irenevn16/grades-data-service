package com.example.demo.Controller;

import com.example.demo.Service.GradeService;
import com.example.demo.model.Grade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/grade")
public class GradeController {

    @Autowired
    private GradeService gradeService;

    @GetMapping
    public List<Grade> getAllGrades(){
        return gradeService.getAllGrades();
    }

    @GetMapping("/{courseCode}")
    public ResponseEntity<?> getGradesByCourseCode(@PathVariable String courseCode){
        return gradeService.getGradesByCourseCode(courseCode);
    }

}
