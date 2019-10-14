package com.spring.jsf.sis.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.jsf.sis.dao.CityRepository;
import com.spring.jsf.sis.dao.DistrictRepository;
import com.spring.jsf.sis.dao.StudentFileRepository;
import com.spring.jsf.sis.dao.StudentRepository;
import com.spring.jsf.sis.model.City;
import com.spring.jsf.sis.model.District;
import com.spring.jsf.sis.model.Student;
import com.spring.jsf.sis.model.StudentFile;

@Service
public class InitDbService {

	@Autowired
	private CityRepository cityRepository;
	
	@Autowired
	private DistrictRepository districtRepository;
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private StudentFileRepository studentFileRepository;

	@PostConstruct
	public void init() {
		System.out.println("*** INIT DATABASE START ***");
		
		{
			City city = new City();
			city.setCityName("Kütahya");
			cityRepository.save(city);
			
			District district = new District();
			district.setDistrictName("Tavþanlý");
			district.setCityId(city.getId());
			district.setCityBean(city);
			districtRepository.save(district);
			
			District district2 = new District();
			district2.setDistrictName("Simav");
			district2.setCityId(city.getId());
			district2.setCityBean(city);
			districtRepository.save(district2);
			
		}
		
		{
			City city = new City();
			city.setCityName("Ýstanbul");
			cityRepository.save(city);
			
			District district = new District();
			district.setDistrictName("Bebek");
			district.setCityId(city.getId());
			district.setCityBean(city);
			districtRepository.save(district);
			
			District district2 = new District();
			district2.setDistrictName("Kadýköy");
			district2.setCityId(city.getId());
			district2.setCityBean(city);
			districtRepository.save(district2);
			
			District district3 = new District();
			district3.setDistrictName("Üsküdar");
			district3.setCityId(city.getId());
			district3.setCityBean(city);
			districtRepository.save(district3);
			
		}
		
		{
			City city = new City();
			city.setCityName("Ýzmir");
			cityRepository.save(city);
			
			District district = new District();
			district.setDistrictName("Bornova");
			district.setCityId(city.getId());
			district.setCityBean(city);
			districtRepository.save(district);
								
		}
		
		{
			City city = new City();
			city.setCityName("Antalya");
			cityRepository.save(city);
			
			District district = new District();
			district.setDistrictName("Alanya");
			district.setCityId(city.getId());
			district.setCityBean(city);
			districtRepository.save(district);
								
		}

		{
			List<StudentFile> studentFiles = new ArrayList<>();
			
			Student student1 = new Student();
			student1.setName("Özge");
			student1.setSurname("Aydýn");
			student1.setMobileNumber("5068612918l");
			student1.setDescription("Özge Açýklama");
			City city = new City();
			city.setCityName("Ankara");
			cityRepository.save(city);
			District district = new District();
			district.setDistrictName("Çankaya");
			district.setCityId(city.getId());
			district.setCityBean(city);
			districtRepository.save(district);
			District district2 = new District();
			district2.setDistrictName("Kýzýlcahamam");
			district2.setCityId(city.getId());
			district2.setCityBean(city);
			districtRepository.save(district2);
			District district3 = new District();
			district3.setDistrictName("Sincan");
			district3.setCityId(city.getId());
			district3.setCityBean(city);
			districtRepository.save(district3);
			
			student1.setDistrictId(district2.getId());
			student1.setDistrictBean(district2);
			student1.setCityId(city.getId());
			student1.setCityBean(city);
			studentRepository.save(student1);
			
			StudentFile studentFile = new StudentFile();
			studentFile.setHeader("Özge deneme belgesi");
			studentFile.setStudentId(student1.getId());
			studentFile.setStudentBean(student1);
			StudentFile studentFile2 = new StudentFile();
			studentFile2.setHeader("Özge deneme belgesi 2");
			studentFile2.setStudentId(student1.getId());
			studentFile2.setStudentBean(student1);
			studentFileRepository.save(studentFile);
			studentFileRepository.save(studentFile2);

			
		}
		
		{
			List<StudentFile> studentFiles = new ArrayList<>();
			
			Student student1 = new Student();
			student1.setName("Oktay");
			student1.setSurname("Aydýn");
			student1.setMobileNumber("5061112255");
			student1.setDescription("Oktay Açýklama");
			City city = new City();
			city.setCityName("Uþak");
			cityRepository.save(city);
			District district = new District();
			district.setDistrictName("Banaz");
			district.setCityId(city.getId());
			district.setCityBean(city);
			districtRepository.save(district);
			District district2 = new District();
			district2.setDistrictName("Merkez");
			district2.setCityId(city.getId());
			district2.setCityBean(city);
			districtRepository.save(district2);
			District district3 = new District();
			district3.setDistrictName("Ulubey");
			district3.setCityId(city.getId());
			district3.setCityBean(city);
			districtRepository.save(district3);

			student1.setDistrictId(district2.getId());
			student1.setDistrictBean(district2);
			student1.setCityId(city.getId());
			student1.setCityBean(city);
			studentRepository.save(student1);
			
			StudentFile studentFile = new StudentFile();
			studentFile.setHeader("Oktay deneme belgesi");
			studentFile.setStudentId(student1.getId());
			studentFile.setStudentBean(student1);
			StudentFile studentFile2 = new StudentFile();
			studentFile2.setHeader("Oktay deneme belgesi 2");
			studentFile2.setStudentId(student1.getId());
			studentFile2.setStudentBean(student1);
			StudentFile studentFile3 = new StudentFile();
			studentFile3.setHeader("Oktay deneme belgesi 2");
			studentFile3.setStudentId(student1.getId());
			studentFile3.setStudentBean(student1);
			studentFileRepository.save(studentFile);
			studentFileRepository.save(studentFile2);
			studentFileRepository.save(studentFile3);
			
		}
		
		{
			List<StudentFile> studentFiles = new ArrayList<>();
			
			Student student1 = new Student();
			student1.setName("Ali");
			student1.setSurname("Öksüz");
			student1.setMobileNumber("5114569875");
			student1.setDescription("Ali Açýklama");
			City city = new City();
			city.setCityName("Manisa");
			cityRepository.save(city);
			District district = new District();
			district.setDistrictName("Salihli");
			district.setCityId(city.getId());
			district.setCityBean(city);
			districtRepository.save(district);
			District district2 = new District();
			district2.setDistrictName("Turgutlu");
			district2.setCityId(city.getId());
			district2.setCityBean(city);
			districtRepository.save(district2);
			District district3 = new District();
			district3.setDistrictName("Merkez");
			district3.setCityId(city.getId());
			district3.setCityBean(city);
			districtRepository.save(district3);

			student1.setDistrictId(district2.getId());
			student1.setDistrictBean(district2);
			student1.setCityId(city.getId());
			student1.setCityBean(city);
			studentRepository.save(student1);
			
			StudentFile studentFile = new StudentFile();
			studentFile.setHeader("Ali deneme belgesi");
			studentFile.setStudentId(student1.getId());
			studentFile.setStudentBean(student1);
			studentFileRepository.save(studentFile);
			
		}



		System.out.println("*** INIT DATABASE FINISH ***");
	}
}
