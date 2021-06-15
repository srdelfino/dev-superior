package com.devsuperior.movieflix.resources.exceptions;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class OAuthCustomError {
    private String error;

    @JsonProperty("error_description")
    private String errorDescription;
}
