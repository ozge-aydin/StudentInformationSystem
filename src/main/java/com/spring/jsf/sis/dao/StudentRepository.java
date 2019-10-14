package com.spring.jsf.sis.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.jsf.sis.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{

}
