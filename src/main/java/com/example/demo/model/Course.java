package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="courses")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {

    @Id
    @Column(name = "course_code")
    private String courseCode;
    private String courseName;
}
