package com.devsuperior.movieflix.dtos;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class ReviewDTO extends AbstractBaseDTO {
    @NotBlank
    private String text;

    private Long movieId;

    private UserDTO user;
}
