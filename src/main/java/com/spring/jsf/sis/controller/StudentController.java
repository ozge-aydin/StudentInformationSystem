package com.spring.jsf.sis.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.spring.jsf.sis.model.City;
import com.spring.jsf.sis.model.District;
import com.spring.jsf.sis.model.Student;
import com.spring.jsf.sis.service.CityService;
import com.spring.jsf.sis.service.DistrictService;
import com.spring.jsf.sis.service.StudentService;


//@Getter
//@Setter
//@ManagedBean
@ViewScoped
@SessionScoped
@Controller
public class StudentController implements Serializable {

	private static final long serialVersionUID = 1L;

//	@ManagedProperty("#{studentService}")
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private DistrictService districtService;
	
	@Autowired
	private CityService cityService;
	
	private List<Student> students;
	
	private Student student = new Student();
	
	private List<District> districts;
	
	private List<City> cities;
	
	
//	@PostConstruct
	public void loadStudents() {
		students = studentService.findAll();
		cities = cityService.findAll();
	}
	
	public String onload() { 
		loadStudents();
	    return "student?faces-redirect=true";
	}
	
	public void save() {
		studentService.save(student);
		student = new Student();
		loadStudents();
		FacesContext.getCurrentInstance().addMessage
			(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Öðrenci kaydetme iþlemi gerçekleþtirilmiþtir!", null));
	}
	
	public void remove(Student student) {
		studentService.remove(student);
		loadStudents();
		FacesContext.getCurrentInstance().addMessage
			(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Öðrenci kaydý silinmiþtir!", null));
	}
	
	public String redirectFilePage() { 
	    return "studentFile?faces-redirect=true";
	}
	
	public void clear() {
		student = new Student();
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
		onCityChange();
	}

	public List<District> getDistricts() {
		return districts;
	}

	public void setDistricts(List<District> districts) {
		this.districts = districts;
	}

	public List<City> getCities() {
		return cities;
	}

	public void setCities(List<City> cities) {
		this.cities = cities;
	}
	
	public void onCityChange() {
		int cityId = this.student.getCityId();
		this.districts = this.districtService.findByCityId(cityId);
	}

}
