package com.devsuperior.bds04.dto;

import java.io.Serializable;
import java.time.LocalDate;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.devsuperior.bds04.entities.Event;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EventDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	
	@NotBlank(message = "Campo requerido")
	private String name;
	
	@FutureOrPresent(message = "A data do evento não pode ser passada")
	private LocalDate date;
	
	private String url;
	
	@NotNull(message = "Campo requerido")
	private Long cityId;
	
	public EventDTO(Event entity) {
		id = entity.getId();
		name = entity.getName();
		date = entity.getDate();
		url = entity.getUrl();
		cityId = entity.getCity().getId();
	}
}
