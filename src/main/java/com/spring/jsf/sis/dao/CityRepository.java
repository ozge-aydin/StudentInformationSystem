package com.spring.jsf.sis.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.jsf.sis.model.City;

public interface CityRepository extends JpaRepository<City, Integer>{

}
