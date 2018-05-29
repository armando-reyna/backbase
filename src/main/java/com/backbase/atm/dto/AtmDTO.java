package com.backbase.atm.dto;

public class AtmDTO {

    private AdressDTO address;
    private Long distance;
    private String type;

    public AdressDTO getAddress() {
        return address;
    }

    public void setAddress(AdressDTO address) {
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
        return "AtmDTO{" +
                "address=" + address +
                ", distance=" + distance +
                ", type='" + type + '\'' +
                '}';
    }
}
