package com.module4.hibernate2_1.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "film_text", schema = "movie")
@Getter
@Setter
public class FilmText {
    @Id
    @Column(name = "film_id")
    private Short id;

    private String title;

    @Column(columnDefinition = "text")
    @Type(type = "text")
    private String description;

    @OneToOne
    @JoinColumn(name = "film_id")
    private Film film;
}