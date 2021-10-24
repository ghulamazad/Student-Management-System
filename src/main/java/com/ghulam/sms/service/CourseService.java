package com.ghulam.sms.service;

import java.util.List;

import com.ghulam.sms.model.Course;
import com.ghulam.sms.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


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
