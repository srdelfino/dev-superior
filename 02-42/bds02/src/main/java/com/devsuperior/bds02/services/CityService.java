package com.devsuperior.bds02.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.bds02.dto.CityDTO;
import com.devsuperior.bds02.entities.City;
import com.devsuperior.bds02.repositories.CityRepository;
import com.devsuperior.bds02.services.exceptions.DataIntegrityException;
import com.devsuperior.bds02.services.exceptions.ResourceNotFoundException;

@Service
public class CityService {
	@Autowired
	private CityRepository repository;
	
	@Transactional(readOnly = true)
	public List<CityDTO> findAll() {
		List<City> entities = repository.findAll(Sort.by("name"));
		List<CityDTO> dtos = entities.stream().map(entity -> new CityDTO(entity)).collect(Collectors.toList());
		return dtos;
	}
	
	@Transactional
	public void deleteById(Long id) {
		try {
			repository.deleteById(id);
			repository.flush();
		} catch (EmptyResultDataAccessException exception) {
			throw new ResourceNotFoundException("ID não encontrado: " + id);
		} catch (DataIntegrityViolationException exception) {
			throw new DataIntegrityException("Violação da integridade referencial");
		}
	}
}
