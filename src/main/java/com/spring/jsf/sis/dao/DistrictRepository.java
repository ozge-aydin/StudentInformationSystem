package com.spring.jsf.sis.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.spring.jsf.sis.model.District;

public interface DistrictRepository extends JpaRepository<District, Integer>{
	
	@Query("SELECT d from District d where d.cityId =:cityId ")       
    List<District> findByCityId(@Param("cityId") int cityId);

}
