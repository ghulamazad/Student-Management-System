package com.student.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.student.model.Student;
import com.student.repository.StudentRepository;

@Service
public class StudentService {
	private StudentRepository studentRepository;

	@Autowired
	public StudentService(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	public Page<Student> findAll(int pageNumber) {
		// get a pageable object from PageRequest class
		Pageable pageable = PageRequest.of(pageNumber - 1, 6);
		return studentRepository.findAll(pageable);
	}

	// find the Student data from db using id
	public Student findById(int id) {
		Optional<Student> optional = studentRepository.findById(id);
		Student student = null;
		if (optional.isPresent()) {
			student = optional.get();
		} else {
			throw new RuntimeException("Student not found for id :: " + id);
		}
		return student;
	}

	// save or update record in db
	public void save(Student student) {
		studentRepository.save(student);
	}
}
