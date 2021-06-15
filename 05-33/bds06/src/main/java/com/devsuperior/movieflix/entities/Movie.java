package com.devsuperior.movieflix.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_movie")
public class Movie extends AbstractBaseEntity {
    @Getter
    @Setter
    private String title;

    @Getter
    @Setter
    private String subTitle;

    @Getter
    @Setter
    private Integer year;

    @Getter
    @Setter
    private String imgUrl;

    @Column(columnDefinition = "text")
    @Getter
    @Setter
    private String synopsis;

    @ManyToOne
    @JoinColumn(name = "genre_id")
    @Getter
    @Setter
    private Genre genre;

    @OneToMany(mappedBy = "movie")
    @Getter
    private Set<Review> reviews = new HashSet<>();
}
