package com.spring.jsf.sis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.jsf.sis.dao.CityRepository;
import com.spring.jsf.sis.model.City;

@Service
@Transactional
public class CityService {

	@Autowired
	private CityRepository cityRepository;
	
	public List<City> findAll() {
		return cityRepository.findAll();
	}

	public void save(City city) {
		cityRepository.save(city);
	}

	public void remove(City city) {
		cityRepository.delete(city);
	}

}
