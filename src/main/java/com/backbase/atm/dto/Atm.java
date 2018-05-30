package com.backbase.atm.dto;

import javax.persistence.*;

@Entity
@Table(name = "atm")
public class Atm {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    private Adress address;

    @Column
    private Long distance;

    @Column
    private String type;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Adress getAddress() {
        return address;
    }

    public void setAddress(Adress address) {
        this.address = address;
    }

    public Long getDistance() {
        return distance;
    }

    public void setDistance(Long distance) {
        this.distance = distance;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Atm{" +
                "id=" + id +
                ", address=" + address +
                ", distance=" + distance +
                ", type='" + type + '\'' +
                '}';
    }
}
