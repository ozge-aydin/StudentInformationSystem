package com.spring.jsf.sis.model;

import java.io.Serializable;
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
 * The persistent class for the district database table.
 * 
 */

@Entity
@Table(name = "district")
public class District implements Serializable {

	private static final Long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "district_name", length = 50)
	@Size(min = 1, message = "Lütfen ilçe adý giriniz..")
	private String districtName;
	
	
	@Column(name = "city_id", insertable = true, updatable = true)
	private int cityId;

	@ManyToOne
	@JoinColumn(name = "city_id", insertable = false, updatable = false )
	private City cityBean;
	
	@OneToMany(cascade= {CascadeType.REMOVE } , mappedBy="districtBean")
	private List<Student> students;
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDistrictName() {
		return districtName;
	}

	public void setDistrictName(String districtName) {
		this.districtName = districtName;
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

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	@Override
	public String toString() {
		return "District [id=" + id + ", districtName=" + districtName + "]";
	}

}
