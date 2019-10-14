package com.spring.jsf.sis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.jsf.sis.dao.StudentFileRepository;
import com.spring.jsf.sis.model.StudentFile;

@Service
@Transactional
public class StudentFileService {

	@Autowired
	private StudentFileRepository studentFileRepository;
	
	public List<StudentFile> findAll() {
		return studentFileRepository.findAll();
	}

	public void save(StudentFile studentFile) {
		studentFileRepository.save(studentFile);
	}

	public void remove(StudentFile studentFile) {
		studentFileRepository.delete(studentFile);
	}
	
	public List<StudentFile> findByStudentId(int studentId) {
		return studentFileRepository.findByStudentId(studentId);
	}
	
	public StudentFile findStudentFile(int studentFileId) {
		return studentFileRepository.findOne(studentFileId);
	}
	
}
