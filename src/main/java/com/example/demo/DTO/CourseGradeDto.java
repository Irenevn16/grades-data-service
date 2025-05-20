package com.example.demo.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseGradeDto {

    private Long courseCode;
    private String courseName;
    private int grade;
    private Long studentId;
}
