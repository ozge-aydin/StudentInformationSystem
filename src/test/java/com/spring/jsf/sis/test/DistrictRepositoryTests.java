package com.spring.jsf.sis.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertArrayEquals;

import java.util.ArrayList;
import java.util.LinkedList;
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
import com.spring.jsf.sis.model.City;
import com.spring.jsf.sis.model.District;



@ContextConfiguration(classes = SpringConfiguration.class)
@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
public class DistrictRepositoryTests {
	
	@Autowired
	private DistrictRepository districtRepository;
	
	@Autowired
	private CityRepository cityRepository;
	
	@Before
	public void setup() {
		
		City city = new City();
		city.setCityName("Ankara");
		cityRepository.save(city);

		District district = new District();
		district.setDistrictName("Sincan");
		district.setCityId(city.getId());
		districtRepository.save(district);
	}
	
	@Test
	public void testDistrictList_shouldReturnAllDistricts() {
		
		List<District> allDistricts = districtRepository.findAll();
		assertNotNull(allDistricts);
	}
	
	@Test
	public void testSaveDistrict_shouldReturnSaveDistrict() {
		
		City city = new City();
		city.setCityName("Ýzmir");
		cityRepository.save(city);
		
		District district = new District();
		district.setDistrictName("Bornova");
		district.setCityId(city.getId());
		district.setCityBean(city);
		districtRepository.save(district);
		
		List<City> cities = new LinkedList<City>();
				cities =cityRepository.findAll();
		List<District> districts = districtRepository.findAll();

		assertEquals("Ýzmir", (cityRepository.getOne(city.getId()).getCityName()));		
		assertEquals("Bornova", (districtRepository.getOne(district.getId()).getDistrictName()));		
			         
	}
	
	@Test
	public void testRemoveDistrict_shouldReturnRemoveDistrict() {
		
		City city = new City();
		city.setCityName("Ýstanbul");
		cityRepository.save(city);
		
		District district = new District();
		district.setDistrictName("Kadýköy");
		district.setCityId(city.getId());
		district.setCityBean(city);
		districtRepository.save(district);
		
		List<District> districts = districtRepository.findAll();
		
		districtRepository.delete(district);
		List<District> districtList = districtRepository.findAll();
		
		assertEquals(districtList.size(),districts.size()-1);
			         
	}
	
	@Test
	public void testFindByCityId_shouldReturnDistrictsFindByCityId() {
		City city = new City();
		city.setCityName("Ýstanbul");
		cityRepository.save(city);
		
		District district = new District();
		district.setDistrictName("Kadýköy");
		district.setCityId(city.getId());
		district.setCityBean(city);
		districtRepository.save(district);
		
		District district2 = new District();
		district2.setDistrictName("Üsküdar");
		district2.setCityId(city.getId());
		district2.setCityBean(city);
		districtRepository.save(district2);
						
		
		List<District> districtFindByCityId = districtRepository.findByCityId(city.getId());
		
		for (District district3 : districtFindByCityId) {
			assertEquals(district3.getCityId(),city.getId());
		}
		
			         
	}


}
