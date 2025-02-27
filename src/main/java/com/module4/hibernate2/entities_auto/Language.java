package com.module4.hibernate2.entities_auto;

import jakarta.persistence.*;

import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "language", schema = "movie")
public class Language {
    @Id
    @Column(name = "language_id", columnDefinition = "tinyint UNSIGNED not null")
    private Short id;

    @Column(name = "name", nullable = false, length = 20)
    private String name;

    @Column(name = "last_update", nullable = false)
    private Instant lastUpdate;

    @OneToMany(mappedBy = "language")
    private Set<Film> films = new LinkedHashSet<>();

    @OneToMany(mappedBy = "originalLanguage")
    private Set<Film> films_o = new LinkedHashSet<>();

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Instant getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Instant lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Set<Film> getFilms() {
        return films;
    }

    public void setFilms(Set<Film> films) {
        this.films = films;
    }

    public Set<Film> getFilms_o() {
        return films_o;
    }

    public void setFilms_o(Set<Film> films_o) {
        this.films_o = films_o;
    }

}