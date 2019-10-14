package com.spring.jsf.sis.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.spring.jsf.sis.model.City;
import com.spring.jsf.sis.service.CityService;

//@Getter
//@Setter
//@ManagedBean
@ViewScoped
//@SessionScoped
@Controller
public class CityController implements Serializable {

	private static final long serialVersionUID = 1L;

//	@ManagedProperty("#{cityService}")
	@Autowired
	private CityService cityService;
	
	private List<City> cities;
	
	public List<City> getCities() {
		return cities;
	}

	public void setCities(List<City> cities) {
		this.cities = cities;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	private City city = new City();
	
//	@PostConstruct
	public void loadCityies() {
		cities = cityService.findAll();
	}
	
	public String onload() { 
		loadCityies();
	    return "city?faces-redirect=true";
	}
	
	public void save() {
		cityService.save(city);
		city = new City();
		loadCityies();
		FacesContext.getCurrentInstance().addMessage
			(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Þehir kaydetme iþlemi gerçekleþtirilmiþtir!", null));
	}
	
	public void remove(City city) {
		cityService.remove(city);
		loadCityies();
		FacesContext.getCurrentInstance().addMessage
			(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Þehir kaydý silinmiþtir!", null));
	}
	
	public void clear() {
		city = new City();
	}
	
}
