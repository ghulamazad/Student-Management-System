package com.student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.model.Course;
import com.student.repository.CourseRepository;

@Service
public class CourseService {
	private CourseRepository courseRepository;

	@Autowired
	public CourseService(CourseRepository courseRepository) {
		this.courseRepository = courseRepository;
	}

	// fetch all the course data from db
	public List<Course> findByAll() {
		return courseRepository.findAll();
	}
}
