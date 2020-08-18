package com.student.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.student.model.Student;

public interface StudentRepository extends PagingAndSortingRepository<Student, Integer> {

}
