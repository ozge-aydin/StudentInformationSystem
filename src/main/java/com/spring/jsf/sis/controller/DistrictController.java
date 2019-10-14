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
import com.spring.jsf.sis.service.CityService;
import com.spring.jsf.sis.service.DistrictService;

//@Getter
//@Setter
//@ManagedBean
@ViewScoped
@SessionScoped
@Controller
public class DistrictController implements Serializable {

	private static final long serialVersionUID = 1L;

//	@ManagedProperty("#{districtService}")
	@Autowired
	private DistrictService districtService;
	
	@Autowired
	private CityService cityService;
	
	private List<District> districts;
	
	private List<City> cities;
	
	private District district = new District();
	
//	@PostConstruct
	public void loadDistricts() {
		districts = districtService.findAll();
		cities = cityService.findAll();
	}
	
	public String onload() { 
		loadDistricts();
	    return "district?faces-redirect=true";
	}
	
	public void save() {
		districtService.save(district);
		district = new District();
		loadDistricts();
		FacesContext.getCurrentInstance().addMessage
			(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Ýlçe kaydetme iþlemi gerçekleþtirilmiþtir!", null));
	}
	
	public void remove(District district) {
		districtService.remove(district);
		loadDistricts();
		FacesContext.getCurrentInstance().addMessage
			(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Ýlçe kaydý silinmiþtir!", null));
	}
	
	public void clear() {
		district = new District();
	}

	public List<District> getDistricts() {
		return districts;
	}

	public void setDistricts(List<District> districts) {
		this.districts = districts;
	}

	public District getDistrict() {
		return district;
	}

	public void setDistrict(District district) {
		this.district = district;
	}

	public List<City> getCities() {
		return cities;
	}

	public void setCities(List<City> cities) {
		this.cities = cities;
	}
	
}
