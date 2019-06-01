package com.spring.boot.interview.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spring.boot.interview.models.CityModel;

@Repository
public interface CityRepository extends CrudRepository<CityModel, Long> {

	@Query("select c from Cidade c where c.name like %?1%")
	List<CityModel> findByName(String name);

	@Query("select c from Cidade c where c.state like %?1%")
	List<CityModel> findByState(String state);
}
