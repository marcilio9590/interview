package com.spring.boot.interview.controllers;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.spring.boot.interview.common.InvalidFieldException;
import com.spring.boot.interview.dtos.CityDTO;
import com.spring.boot.interview.services.cidade.ICityService;

@RestController
@RequestMapping(value = "/v1/cidades", produces = MediaType.APPLICATION_JSON_VALUE)
public class CityController {

	@Autowired
	private ICityService service;

	@PostMapping
	public CityDTO save(@Valid @RequestBody CityDTO city) throws InvalidFieldException {
		return service.save(city);
	}

	@GetMapping("/nome/{name}")
	public List<CityDTO> findByName(@NotEmpty @RequestParam String name) throws InvalidFieldException {
		return service.findByName(name);
	}

	@GetMapping("/state/{state}")
	public List<CityDTO> finByState(@NotEmpty @RequestParam String state) throws InvalidFieldException {
		return service.findByState(state);
	}

	@ExceptionHandler
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public String handleInvalidFields(InvalidFieldException ex) {
		return ex.getMessage();
	}

}
