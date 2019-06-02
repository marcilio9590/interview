package com.spring.boot.interview.services.cliente.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.boot.interview.common.InvalidFieldException;
import com.spring.boot.interview.common.ValidateUtil;
import com.spring.boot.interview.dtos.ClientDTO;
import com.spring.boot.interview.dtos.UpdateClientDTO;
import com.spring.boot.interview.factories.ClientFactory;
import com.spring.boot.interview.models.ClientModel;
import com.spring.boot.interview.repositories.ClientRepository;
import com.spring.boot.interview.services.cliente.IClientService;

@Service
public class ClientServiceImpl implements IClientService {

	private static final long serialVersionUID = 2237970666017727580L;

	@Autowired
	private ClientFactory factory;

	@Autowired
	private ClientRepository repository;

	@Override
	@Transactional
	public ClientDTO save(ClientDTO clienteParam) throws InvalidFieldException {
		validate(clienteParam);
		ClientModel entity = factory.dtoToEntity(clienteParam);
		return factory.entityToDto(repository.save(entity));
	}

	@Override
	@Transactional
	public List<ClientDTO> findByName(String clientName) throws InvalidFieldException {
		List<ClientDTO> exit = null;
		exit = factory.listEntityToListDto(repository.findByName(clientName.toLowerCase()));
		return exit;
	}

	@Override
	@Transactional
	public ClientDTO findById(Long clientId) throws InvalidFieldException {
		ClientDTO exit = null;
		Optional<ClientModel> model = repository.findById(clientId);
		if (model.isPresent()) {
			exit = factory.entityToDto(model.get());
		}
		return exit;
	}

	@Override
	public Boolean deleteById(Long clientId) throws InvalidFieldException {
		Boolean saida = Boolean.FALSE;
		repository.deleteById(clientId);
		saida = Boolean.TRUE;
		return saida;
	}

	@Override
	@Transactional
	public ClientDTO updateName(UpdateClientDTO client) throws InvalidFieldException {
		Optional<ClientModel> cli = repository.findById(client.getId());
		if (cli.isPresent()) {
			cli.get().setName(client.getName());
			return factory.entityToDto(repository.save(cli.get()));
		} else {
			throw new InvalidFieldException("Código do cliente inválido.");
		}
	}

	private void validate(ClientDTO dto) throws InvalidFieldException {
		if (ValidateUtil.stringToSexoEnum(dto.getGender()) == null) {
			throw new InvalidFieldException("Sexo Inválido, favor informar M ou F");
		}
		if (ValidateUtil.stringToDate(dto.getDtBirth()) == null) {
			throw new InvalidFieldException("Data de Nascimento Inválida, favor informar dd/mm/aaaa");
		}
		if (!ValidateUtil.isEmptyOrNull(dto.getCity())) {
			validateCity(dto.getCity().getName());
			validateState(dto.getCity().getState());
		}
	}

	private void validateState(String state) throws InvalidFieldException {
		if (!ValidateUtil.isStateValid(state)) {
			throw new InvalidFieldException("Estado Inválida.");
		}

	}

	private void validateCity(String name) throws InvalidFieldException {
		if (ValidateUtil.isEmptyOrNull(name)) {
			throw new InvalidFieldException("Cidade Inválida.");
		}
	}

}
