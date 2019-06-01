package com.spring.boot.interview.services.cidade;

import java.io.Serializable;
import java.util.List;

import com.spring.boot.interview.common.InvalidFieldException;
import com.spring.boot.interview.dtos.CityDTO;

public interface ICityService extends Serializable {

	public CityDTO save(CityDTO city) throws InvalidFieldException;

	public List<CityDTO> findByName(String name) throws InvalidFieldException;

	public List<CityDTO> findByState(String state) throws InvalidFieldException;

}
