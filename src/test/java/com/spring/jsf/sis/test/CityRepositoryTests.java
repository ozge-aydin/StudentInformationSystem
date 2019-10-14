package com.spring.jsf.sis.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

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
import com.spring.jsf.sis.model.City;



@ContextConfiguration(classes = SpringConfiguration.class)
@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
public class CityRepositoryTests {
	

	@Autowired
	private CityRepository cityRepository;
	
	@Before
	public void setup() {

		City city = new City();
		city.setCityName("Ankara");
		cityRepository.save(city);
	}
	
	@Test
	public void testCityList_shouldReturnAllCities() {
		
		List<City> allCities = cityRepository.findAll();
		assertNotNull(allCities);
	}
	
	@Test
	public void testSaveCity_shouldReturnSaveCity() {
		
		City city = new City();
		city.setCityName("Ýzmir");
		cityRepository.save(city);

		List<City> cities = cityRepository.findAll();
		
		assertEquals("Ýzmir", (cityRepository.getOne(city.getId()).getCityName()));
	         
	}
	
	@Test
	public void testRemoveCity_shouldReturnRemoveCity() {
		
		City city = new City();
		city.setCityName("Uþak");
		cityRepository.save(city);
		List<City> cities = cityRepository.findAll();
		
		cityRepository.delete(city);
		List<City> cityList = cityRepository.findAll();
		
		assertEquals(cityList.size(),cities.size()-1);
			         
	}

}
