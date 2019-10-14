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
import com.spring.jsf.sis.dao.StudentFileRepository;
import com.spring.jsf.sis.dao.StudentRepository;
import com.spring.jsf.sis.model.City;
import com.spring.jsf.sis.model.District;
import com.spring.jsf.sis.model.Student;
import com.spring.jsf.sis.model.StudentFile;


@ContextConfiguration(classes = SpringConfiguration.class)
@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
public class StudentFileRepositoryTests {
	
	@Autowired
	private CityRepository cityRepository;
	
	@Autowired
	private DistrictRepository districtRepository;
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private StudentFileRepository studentFileRepository;
	
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
		
		StudentFile studentFile = new StudentFile();
		studentFile.setHeader("deneme belgesi");
		studentFile.setStudentId(student1.getId());
		studentFile.setStudentBean(student1);
		
		StudentFile studentFile2 = new StudentFile();
		studentFile2.setHeader("deneme belgesi 2");
		studentFile2.setStudentId(student1.getId());
		studentFile2.setStudentBean(student1);
		
		studentFileRepository.save(studentFile);
		studentFileRepository.save(studentFile2);

	}
	
	@Test
	public void testStudentFileList_shouldReturnAllStudentFiles() {
		
		List<StudentFile> studentFiles = studentFileRepository.findAll();
		assertNotNull(studentFiles);
	}
	
	@Test
	public void testSaveStudentFile_shouldReturnSaveStudentFile() {
		
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
		
		StudentFile studentFile = new StudentFile();
		studentFile.setHeader("deneme belgesi");
		studentFile.setStudentId(student1.getId());
		studentFile.setStudentBean(student1);
		
		StudentFile studentFile2 = new StudentFile();
		studentFile2.setHeader("deneme belgesi 2");
		studentFile2.setStudentId(student1.getId());
		studentFile2.setStudentBean(student1);
		
		studentFileRepository.save(studentFile);
		studentFileRepository.save(studentFile2);

		assertEquals("Özge", (studentRepository.getOne(student1.getId()).getName()));		
		assertEquals("deneme belgesi", (studentFileRepository.getOne(studentFile.getId()).getHeader()));
		assertEquals("deneme belgesi 2", (studentFileRepository.getOne(studentFile2.getId()).getHeader()));
		assertEquals("Kütahya", (cityRepository.getOne(city.getId()).getCityName()));		
		assertEquals("Tavþanlý", (districtRepository.getOne(district.getId()).getDistrictName()));	
	         
	}
	
	@Test
	public void testRemoveStudentFile_shouldReturnRemoveStudentFile() {

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
		
		StudentFile studentFile = new StudentFile();
		studentFile.setHeader("deneme belgesi");
		studentFile.setStudentId(student1.getId());
		studentFile.setStudentBean(student1);
		
		StudentFile studentFile2 = new StudentFile();
		studentFile2.setHeader("deneme belgesi 2");
		studentFile2.setStudentId(student1.getId());
		studentFile2.setStudentBean(student1);
		
		studentFileRepository.save(studentFile);
		studentFileRepository.save(studentFile2);
		
		List<StudentFile> studentFiles = studentFileRepository.findAll();
		
		studentFileRepository.delete(studentFile);
		List<StudentFile> studentFileList = studentFileRepository.findAll();
		
		assertEquals(studentFileList.size(),studentFiles.size()-1);
			         
	}
	
	@Test
	public void testFindByStudentId_shouldReturnStudentFilesFindByStudentId() {
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
		
		StudentFile studentFile = new StudentFile();
		studentFile.setHeader("deneme belgesi");
		studentFile.setStudentId(student1.getId());
		studentFile.setStudentBean(student1);
		
		StudentFile studentFile2 = new StudentFile();
		studentFile2.setHeader("deneme belgesi 2");
		studentFile2.setStudentId(student1.getId());
		studentFile2.setStudentBean(student1);
		
		studentFileRepository.save(studentFile);
		studentFileRepository.save(studentFile2);
		
		List<StudentFile> studentFiles = studentFileRepository.findByStudentId(student1.getId());
		
		for (StudentFile studentFile3 : studentFiles) {
			assertEquals(studentFile3.getStudentId(),student1.getId());
		}
			         
	}
	
	@Test
	public void testFindStudentFile_shouldReturnStudentFileFindStudentFile() {
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
		
		StudentFile studentFile = new StudentFile();
		studentFile.setHeader("deneme belgesi");
		studentFile.setStudentId(student1.getId());
		studentFile.setStudentBean(student1);
		
		
		studentFileRepository.save(studentFile);

		StudentFile studentFile2 = studentFileRepository.getOne(studentFile.getId());
		assertEquals(studentFile2.getHeader(), studentFile.getHeader());
		assertNotNull(studentFile2);
			         
	}


}
