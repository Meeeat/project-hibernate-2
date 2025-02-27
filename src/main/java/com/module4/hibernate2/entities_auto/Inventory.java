package com.module4.hibernate2.entities_auto;

import jakarta.persistence.*;

import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "inventory", schema = "movie", indexes = {
        @Index(name = "idx_fk_film_id", columnList = "film_id"),
        @Index(name = "idx_store_id_film_id", columnList = "store_id, film_id")
})
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "inventory_id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "film_id", nullable = false)
    private Film film;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "store_id", nullable = false)
    private com.module4.hibernate2.entities_auto.Store store;

    @Column(name = "last_update", nullable = false)
    private Instant lastUpdate;

    @OneToMany(mappedBy = "inventory")
    private Set<com.module4.hibernate2.entities_auto.Rental> rentals = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public com.module4.hibernate2.entities_auto.Store getStore() {
        return store;
    }

    public void setStore(com.module4.hibernate2.entities_auto.Store store) {
        this.store = store;
    }

    public Instant getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Instant lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Set<com.module4.hibernate2.entities_auto.Rental> getRentals() {
        return rentals;
    }

    public void setRentals(Set<com.module4.hibernate2.entities_auto.Rental> rentals) {
        this.rentals = rentals;
    }

}