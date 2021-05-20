package br.pro.delfino.trabalhofinal.service;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.pro.delfino.trabalhofinal.dto.ClientDTO;
import br.pro.delfino.trabalhofinal.entities.Client;
import br.pro.delfino.trabalhofinal.repository.ClientRepository;
import br.pro.delfino.trabalhofinal.service.exceptions.DataIntegrityException;
import br.pro.delfino.trabalhofinal.service.exceptions.ResourceNotFoundException;

@Service
public class ClientService {
	@Autowired
	private ClientRepository repository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Transactional(readOnly = true)
	public Page<ClientDTO> findAll(PageRequest pageRequest) {
		Page<Client> list = repository.findAll(pageRequest);
		
		Page<ClientDTO> listDTO = list
			.map(entity -> modelMapper.map(entity, ClientDTO.class));

		return listDTO;
	}

	@Transactional(readOnly = true)
	public ClientDTO findById(Long id) {
		Optional<Client> optional = repository.findById(id);

		Client entity = optional.orElseThrow(() -> new ResourceNotFoundException("Entidade não encontrada"));

		ClientDTO dto = modelMapper.map(entity, ClientDTO.class);
		return dto;
	}

	@Transactional
	public ClientDTO insert(ClientDTO dto) {
		Client entity = modelMapper.map(dto, Client.class);

		repository.save(entity);

		dto = modelMapper.map(entity, ClientDTO.class);
		return dto;
	}

	@Transactional
	public ClientDTO update(Long id, ClientDTO dto) {
		try {
			Client entity = repository.getOne(id);
			
			modelMapper.typeMap(ClientDTO.class, Client.class).addMappings(mapper -> {
		        mapper.skip(Client::setId);
		    });
			
			modelMapper.map(dto, entity);

			repository.save(entity);

			dto = modelMapper.map(entity, ClientDTO.class);
			return dto;
		} catch (EntityNotFoundException exception) {
			throw new ResourceNotFoundException("ID não encontrado: " + id);
		}
	}

	@Transactional
	public void deleteById(Long id) {
		try {
			repository.deleteById(id);
			repository.flush();
		} catch (EmptyResultDataAccessException exception) {
			throw new ResourceNotFoundException("ID não encontrado: " + id);
		} catch (DataIntegrityViolationException exception) {
			throw new DataIntegrityException("Violação de integridade referencial");
		}
	}
}
