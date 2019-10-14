package com.spring.jsf.sis.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.spring.jsf.sis.model.StudentFile;

public interface StudentFileRepository extends JpaRepository<StudentFile, Integer>{
	
	@Query("SELECT f from StudentFile f where f.studentId =:studentId ")       
    List<StudentFile> findByStudentId(@Param("studentId") int studentId);

}
