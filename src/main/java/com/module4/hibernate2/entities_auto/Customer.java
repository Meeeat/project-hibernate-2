package com.module4.hibernate2.entities_auto;

import jakarta.persistence.*;

import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "customer", schema = "movie", indexes = {
        @Index(name = "idx_fk_store_id", columnList = "store_id"),
        @Index(name = "idx_last_name", columnList = "last_name"),
        @Index(name = "idx_fk_address_id", columnList = "address_id")
})
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id", columnDefinition = "smallint UNSIGNED not null")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "store_id", nullable = false)
    private com.module4.hibernate2.entities_auto.Store store;

    @Column(name = "first_name", nullable = false, length = 45)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 45)
    private String lastName;

    @Column(name = "email", length = 50)
    private String email;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "address_id", nullable = false)
    private Address address;

    @Column(name = "active", nullable = false)
    private Boolean active = false;

    @Column(name = "create_date", nullable = false)
    private Instant createDate;

    @Column(name = "last_update")
    private Instant lastUpdate;

    @OneToMany(mappedBy = "customer")
    private Set<com.module4.hibernate2.entities_auto.Payment> payments = new LinkedHashSet<>();

    @OneToMany(mappedBy = "customer")
    private Set<com.module4.hibernate2.entities_auto.Rental> rentals = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public com.module4.hibernate2.entities_auto.Store getStore() {
        return store;
    }

    public void setStore(com.module4.hibernate2.entities_auto.Store store) {
        this.store = store;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Instant getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Instant createDate) {
        this.createDate = createDate;
    }

    public Instant getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Instant lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Set<com.module4.hibernate2.entities_auto.Payment> getPayments() {
        return payments;
    }

    public void setPayments(Set<com.module4.hibernate2.entities_auto.Payment> payments) {
        this.payments = payments;
    }

    public Set<com.module4.hibernate2.entities_auto.Rental> getRentals() {
        return rentals;
    }

    public void setRentals(Set<com.module4.hibernate2.entities_auto.Rental> rentals) {
        this.rentals = rentals;
    }

}