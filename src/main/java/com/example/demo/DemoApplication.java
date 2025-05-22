package com.example.demo;

import com.example.demo.Repository.CourseRepository;
import com.example.demo.Repository.GradeRepository;
import com.example.demo.model.Course;
import com.example.demo.model.Grade;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@SpringBootApplication
public class DemoApplication {
	@Bean
	@LoadBalanced
	public RestTemplate getRestTemplate(){
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	//inicia los datos si no hay previamente, por lo que no se crearán una y otra vez
	@Bean
	CommandLineRunner initGradesData(CourseRepository courseRepository, GradeRepository gradeRepository) {
		return args -> {
			if (courseRepository.count() == 0) {
				Course c1 = new Course("C001", "Matemáticas");
				Course c2 = new Course("C002", "Historia");
				Course c3 = new Course("C003", "Física");
				Course c4 = new Course("C004", "Lengua");
				courseRepository.saveAll(List.of(c1, c2, c3, c4));

				if (gradeRepository.count() == 0) {
					gradeRepository.save(new Grade(null, 8.5, c1, 1L)); // Carlos
					gradeRepository.save(new Grade(null, 7.0, c2, 2L)); // Laura
					gradeRepository.save(new Grade(null, 9.2, c3, 3L)); // Inés
					gradeRepository.save(new Grade(null, 6.8, c4, 4L)); // Juan
					gradeRepository.save(new Grade(null, 5.5, c2, 1L)); // Carlos para Historia
				}
			}
		};
	}

}
