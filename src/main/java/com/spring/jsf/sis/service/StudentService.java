package com.spring.jsf.sis.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.jsf.sis.dao.StudentRepository;
import com.spring.jsf.sis.model.Student;

@Service
@Transactional
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;
	
	public List<Student> findAll() {
		return studentRepository.findAll();
	}

	public void save(Student student) {
		studentRepository.save(student);
	}

	public void remove(Student student) {
		studentRepository.delete(student);
	}

}
