package com.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.student.model.Course;

public interface CourseRepository extends JpaRepository<Course, Integer> {

}
