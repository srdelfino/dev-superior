package com.devsuperior.movieflix.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MovieDTO extends AbstractBaseDTO {
    private String title;

    private String subTitle;

    private Integer year;

    private String imgUrl;

    private String synopsis;

    private GenreDTO genre;
}
