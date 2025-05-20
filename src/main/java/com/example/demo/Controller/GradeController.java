package com.example.demo.Controller;

import com.example.demo.Service.GradeService;
import com.example.demo.model.Grade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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


}
