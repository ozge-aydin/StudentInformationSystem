package com.spring.jsf.sis.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.spring.jsf.sis.SpringConfiguration;
import com.spring.jsf.sis.dao.CityRepository;
import com.spring.jsf.sis.dao.DistrictRepository;
import com.spring.jsf.sis.dao.StudentRepository;
import com.spring.jsf.sis.model.City;
import com.spring.jsf.sis.model.District;
import com.spring.jsf.sis.model.Student;



@ContextConfiguration(classes = SpringConfiguration.class)
@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
public class StudentRepositoryTests {
	
	
	@Autowired
	private CityRepository cityRepository;
	
	@Autowired
	private DistrictRepository districtRepository;
	
	@Autowired
	private StudentRepository studentRepository;
	
	
	@Before
	public void setup() {

		Student student1 = new Student();
		student1.setName("Özge");
		student1.setSurname("Aydýn");
		student1.setMobileNumber("5068612918l");
		student1.setDescription("Özge Açýklama");
		City city = new City();
		city.setCityName("Kütahya");
		cityRepository.save(city);
		student1.setCityBean(city);
		student1.setCityId(city.getId());
		District district = new District();
		district.setDistrictName("Tavþanlý");
		district.setCityId(city.getId());
		district.setCityBean(city);
		districtRepository.save(district);
		student1.setDistrictId(district.getId());
		student1.setDistrictBean(district);
		studentRepository.save(student1);
		
	}
	
	@Test
	public void testStudentList_shouldReturnAllStudents() {
		
		List<Student> allStudents = studentRepository.findAll();
		assertNotNull(allStudents);
	}
	
	@Test
	public void testSaveStudent_shouldReturnSaveStudent() {
		
		Student student1 = new Student();
		student1.setName("Özge");
		student1.setSurname("Aydýn");
		student1.setMobileNumber("5068612918l");
		student1.setDescription("Özge Açýklama");
		City city = new City();
		city.setCityName("Kütahya");
		cityRepository.save(city);
		student1.setCityBean(city);
		student1.setCityId(city.getId());
		District district = new District();
		district.setDistrictName("Tavþanlý");
		district.setCityId(city.getId());
		district.setCityBean(city);
		districtRepository.save(district);
		
		student1.setDistrictId(district.getId());
		student1.setDistrictBean(district);
		studentRepository.save(student1);
		
		
		assertEquals("Özge", (studentRepository.getOne(student1.getId()).getName()));		
		assertEquals("Kütahya", (cityRepository.getOne(city.getId()).getCityName()));		
		assertEquals("Tavþanlý", (districtRepository.getOne(district.getId()).getDistrictName()));
				
	         
	}
	
	
	@Test
	public void testRemoveStudent_shouldReturnRemoveStudent() {

		Student student1 = new Student();
		student1.setName("Özge");
		student1.setSurname("Aydýn");
		student1.setMobileNumber("5068612918l");
		student1.setDescription("Özge Açýklama");
		City city = new City();
		city.setCityName("Kütahya");
		cityRepository.save(city);
		student1.setCityBean(city);
		student1.setCityId(city.getId());
		District district = new District();
		district.setDistrictName("Tavþanlý");
		district.setCityId(city.getId());
		district.setCityBean(city);
		districtRepository.save(district);
		student1.setDistrictId(district.getId());
		student1.setDistrictBean(district);
		studentRepository.save(student1);
		
		List<Student> students = studentRepository.findAll();
		
		studentRepository.delete(student1);
		List<Student> studentList = studentRepository.findAll();
		
		assertEquals(studentList.size(),students.size()-1);
			         
	}


}
