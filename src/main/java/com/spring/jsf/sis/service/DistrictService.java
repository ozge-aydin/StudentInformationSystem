package com.spring.jsf.sis.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.jsf.sis.dao.DistrictRepository;
import com.spring.jsf.sis.model.District;

@Service
@Transactional
public class DistrictService {

	@Autowired
	private DistrictRepository districtRepository;
	
	public List<District> findAll() {
		return districtRepository.findAll();
	}

	public void save(District district) {
		districtRepository.save(district);
	}

	public void remove(District district) {
		districtRepository.delete(district);
	}
	
	public List<District> findByCityId(int cityId) {
		return districtRepository.findByCityId(cityId);
	}

}
