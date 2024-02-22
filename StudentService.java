package com.sts.ProductList.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sts.ProductList.entity.Student;
import com.sts.ProductList.repository.StudentRepo;

@Service
public class StudentService {
	@Autowired
	private StudentRepo studentRepo ;

	public Student saveStudentData( Student student) {
		Student savedStudent =  studentRepo.save(student);
		return savedStudent;		
	}

	public List<Student> getAllDetails() {
        return studentRepo.findAll();
    }
	
}
