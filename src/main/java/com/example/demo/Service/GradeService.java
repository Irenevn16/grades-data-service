package com.example.demo.Service;

import com.example.demo.Repository.GradeRepository;
import com.example.demo.model.Grade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GradeService {
    @Autowired
    private GradeRepository gradeRepository;

    public List<Grade> getAllGrades(){
        return gradeRepository.findAll();
    }
}
