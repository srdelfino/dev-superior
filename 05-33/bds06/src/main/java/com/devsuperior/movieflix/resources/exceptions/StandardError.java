package com.devsuperior.movieflix.resources.exceptions;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
public class StandardError {
	private Instant timestamp;

	private Integer status;

	private String error;

	private String message;

	private String path;
}
