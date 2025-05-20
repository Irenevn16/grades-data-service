package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="grades")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Grade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double grade;

    @ManyToOne
    @JoinColumn(name = "course_code")
    private Course course;

    @Column(name = "studentId")
    private Long studentId;
}
