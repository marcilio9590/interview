package com.spring.boot.interview.services.cidade.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.boot.interview.common.InvalidFieldException;
import com.spring.boot.interview.common.InterviewUtil;
import com.spring.boot.interview.dtos.CityDTO;
import com.spring.boot.interview.factories.CityFactory;
import com.spring.boot.interview.models.CityModel;
import com.spring.boot.interview.repositories.CityRepository;
import com.spring.boot.interview.services.cidade.ICityService;

@Service
public class CityServiceImpl implements ICityService {

	private static final long serialVersionUID = -5302166885165609422L;

	@Autowired
	private CityRepository repository;

	@Autowired
	private CityFactory factory;

	@Override
	public CityDTO save(CityDTO city) throws InvalidFieldException {
		validate(city);
		CityModel entity = factory.dtoToEntity(city);
		return factory.entityToDto(repository.save(entity));
	}

	@Override
	public List<CityDTO> findByName(String name) throws InvalidFieldException {
		return factory.listEntityToListDto(repository.findByName(name.toLowerCase()));
	}

	@Override
	public List<CityDTO> findByState(String state) throws InvalidFieldException {
		return factory.listEntityToListDto(repository.findByState(state.toLowerCase()));
	}

	private void validate(CityDTO city) throws InvalidFieldException {
		if (InterviewUtil.isEmptyOrNull(city.getName())) {
			throw new InvalidFieldException("Nome da cidade inválido.");
		}
		if (!InterviewUtil.isStateValid(city.getState())) {
			throw new InvalidFieldException("Sigla do estado inválida.");
		}
	}

}
