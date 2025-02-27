package com.module4.hibernate2.entities_auto;

import jakarta.persistence.*;

import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "address", schema = "movie", indexes = {
        @Index(name = "idx_fk_city_id", columnList = "city_id")
})
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id", columnDefinition = "smallint UNSIGNED not null")
    private Integer id;

    @Column(name = "address", nullable = false, length = 50)
    private String address;

    @Column(name = "address2", length = 50)
    private String address2;

    @Column(name = "district", nullable = false, length = 20)
    private String district;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "city_id", nullable = false)
    private com.module4.hibernate2.entities_auto.City city;

    @Column(name = "postal_code", length = 10)
    private String postalCode;

    @Column(name = "phone", nullable = false, length = 20)
    private String phone;

    @Column(name = "last_update", nullable = false)
    private Instant lastUpdate;

    @OneToMany(mappedBy = "address")
    private Set<com.module4.hibernate2.entities_auto.Customer> customers = new LinkedHashSet<>();

    @OneToMany(mappedBy = "address")
    private Set<com.module4.hibernate2.entities_auto.Staff> staff = new LinkedHashSet<>();

    @OneToMany(mappedBy = "address")
    private Set<com.module4.hibernate2.entities_auto.Store> stores = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public com.module4.hibernate2.entities_auto.City getCity() {
        return city;
    }

    public void setCity(com.module4.hibernate2.entities_auto.City city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Instant getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Instant lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Set<com.module4.hibernate2.entities_auto.Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(Set<com.module4.hibernate2.entities_auto.Customer> customers) {
        this.customers = customers;
    }

    public Set<com.module4.hibernate2.entities_auto.Staff> getStaff() {
        return staff;
    }

    public void setStaff(Set<com.module4.hibernate2.entities_auto.Staff> staff) {
        this.staff = staff;
    }

    public Set<com.module4.hibernate2.entities_auto.Store> getStores() {
        return stores;
    }

    public void setStores(Set<com.module4.hibernate2.entities_auto.Store> stores) {
        this.stores = stores;
    }

}