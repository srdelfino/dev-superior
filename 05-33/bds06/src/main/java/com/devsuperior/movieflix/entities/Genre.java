package com.devsuperior.movieflix.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_genre")
public class Genre extends AbstractBaseEntity {
    @Getter
    @Setter
    private String name;

    @OneToMany(mappedBy = "genre")
    @Getter
    private Set<Movie> movies = new HashSet<>();
}
