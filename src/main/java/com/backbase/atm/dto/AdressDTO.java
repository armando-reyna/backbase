package com.backbase.atm.dto;

public class AdressDTO {

    private String street;
    private String housenumber;
    private String postalcode;
    private String city;
    private GeolocationDTO geoLocation;

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHousenumber() {
        return housenumber;
    }

    public void setHousenumber(String housenumber) {
        this.housenumber = housenumber;
    }

    public String getPostalcode() {
        return postalcode;
    }

    public void setPostalcode(String postalcode) {
        this.postalcode = postalcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public GeolocationDTO getGeoLocation() {
        return geoLocation;
    }

    public void setGeoLocation(GeolocationDTO geoLocation) {
        this.geoLocation = geoLocation;
    }

    @Override
    public String toString() {
        return "AdressDTO{" +
                "street='" + street + '\'' +
                ", housenumber='" + housenumber + '\'' +
                ", postalcode='" + postalcode + '\'' +
                ", city='" + city + '\'' +
                ", geoLocation=" + geoLocation +
                '}';
    }
}
