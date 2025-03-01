package com.module4.hibernate2_1.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Table(name = "film", schema = "movie")
@Getter
@Setter
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "film_id")
    private Short id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(columnDefinition = "text")
    private String description;

    @Column(name = "release_year", columnDefinition = "year")
    private Integer releaseYear;

    @ManyToOne
    @JoinColumn(name = "language_id")
    private Language language;

    @ManyToOne
    @JoinColumn(name = "original_language_id")
    private Language originalLanguage;

    @Column(name = "rental_duration")
    private Byte rentalDuration;

    @Column(name = "rental_rate")
    private BigDecimal rentalRate;

    @Column(name = "length")
    private Short length;

    @Column(name = "replacement_cost")
    private BigDecimal replacementCost;

    @Column(name = "rating", columnDefinition = "ENUM('G', 'PG', 'PG-13', 'R', 'NC-17')")
    @Enumerated(EnumType.STRING)
    private Rating rating;

    @Column(name = "special_features", columnDefinition = "set('Trailers', 'Commentaries', 'Deleted Scenes', 'Behind the Scenes')")
    private String specialFeatures;

    @Transient
    private Set<SpecialFeature> features;

    @PostLoad
    private void postLoad() {
        if (specialFeatures != null && !specialFeatures.isEmpty()) {
            features = Arrays.stream(specialFeatures.split(","))
                    .map(String::trim)
                    .map(SpecialFeature::getFeatureByValue)
                    .filter(Objects::nonNull)
                    .collect(Collectors.toSet());
        } else {
            features = Collections.emptySet();
        }
    }

    @PrePersist
    @PreUpdate
    private void prePersistOrUpdate() {
        if (features != null && !features.isEmpty()) {
            specialFeatures = features.stream()
                    .map(SpecialFeature::getValue)
                    .collect(Collectors.joining(","));
        } else {
            specialFeatures = null;
        }
    }

    @Column(name = "last_update")
    @UpdateTimestamp
    private LocalDateTime lastUpdate;



    @ManyToMany
    @JoinTable(name = "film_actor",
            joinColumns = @JoinColumn(name = "film_id", referencedColumnName = "film_id"),
            inverseJoinColumns = @JoinColumn(name = "actor_id", referencedColumnName = "actor_id"))
    private Set<Actor> actors;

    @ManyToMany
    @JoinTable(name = "film_category",
            joinColumns = @JoinColumn(name = "film_id", referencedColumnName = "film_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id", referencedColumnName = "category_id"))
    private Set<Category> categories;
}