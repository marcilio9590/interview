package com.spring.boot.interview.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.boot.interview.dtos.ClientDTO;
import com.spring.boot.interview.services.cliente.IClientService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	private IClientService clienteService;

	@PostMapping
	public ClientDTO insert(@Valid @RequestBody ClientDTO clientParam) {
		return clienteService.save(clientParam);
	}

	@GetMapping("/{clientName}")
	public List<ClientDTO> findByName(@Valid @PathVariable String clientName) {
		return clienteService.findByName(clientName);
	}

}
