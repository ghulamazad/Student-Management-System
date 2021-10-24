package com.ghulam.sms.repository;

import com.ghulam.sms.model.Student;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface StudentRepository extends PagingAndSortingRepository<Student, Integer> {

}
