package com.spring.jsf.sis.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 * The persistent class for the student database table.
 * 
 */

@Entity
@Table(name="student")
public class Student implements Serializable {
	
	private static final Long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="name", length=50)
	@Size(min = 1, message = "Lütfen öðrenci adý giriniz..")
	private String name;

	@Column(name="surname", length=50)
	@Size(min = 1, message = "Lütfen öðrenci soyadý giriniz..")
	private String surname;
	
	@Column(name="mobile_Number",length=15)
	private String mobileNumber;
	
	@Column(name = "city_id", insertable = true, updatable = true)
	private int cityId;

	@ManyToOne
	@JoinColumn(name = "city_id", insertable = false, updatable = false)
	private City cityBean;
	
	@Column(name = "district_id", insertable = true, updatable = true)
	private int districtId;

	@ManyToOne
	@JoinColumn(name = "district_id", insertable = false, updatable = false)
	private District districtBean;
	
	@Column(name="description",length=500)
	private String description;
	
	@Column(name="date_created")
	private Date dateCreated = new Date();
		
	@OneToMany(cascade= {CascadeType.REMOVE }, mappedBy="studentBean")
	private List<StudentFile> studentFiles;


	public String getName() {
		return name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public int getCityId() {
		return cityId;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
	}

	public City getCityBean() {
		return cityBean;
	}

	public void setCityBean(City cityBean) {
		this.cityBean = cityBean;
	}

	public int getDistrictId() {
		return districtId;
	}

	public void setDistrictId(int districtId) {
		this.districtId = districtId;
	}

	public District getDistrictBean() {
		return districtBean;
	}

	public void setDistrictBean(District districtBean) {
		this.districtBean = districtBean;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}


	public List<StudentFile> getStudentFiles() {
		return studentFiles;
	}

	public void setStudentFiles(List<StudentFile> studentFiles) {
		this.studentFiles = studentFiles;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", surname=" + surname + ", mobileNumber=" + mobileNumber
				+ ", cityId=" + cityId + ", cityBean=" + cityBean + ", districtId=" + districtId + ", districtBean="
				+ districtBean + ", description=" + description + ", dateCreated=" + dateCreated + "]";
	}

}
