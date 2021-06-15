package com.devsuperior.movieflix.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO extends AbstractBaseDTO {
    private String name;

    private String email;
}
