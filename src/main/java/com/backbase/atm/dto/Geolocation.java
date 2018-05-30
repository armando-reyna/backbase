package com.backbase.atm.dto;

import javax.persistence.*;

@Entity
@Table(name = "geolocation", uniqueConstraints = @UniqueConstraint(name = "uc_address", columnNames = {"lat", "lng"}))
public class Geolocation {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column
    private Double lat;

    @Column
    private Double lng;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    @Override
    public String toString() {
        return "Geolocation{" +
                "id=" + id +
                ", lat=" + lat +
                ", lng=" + lng +
                '}';
    }
}
