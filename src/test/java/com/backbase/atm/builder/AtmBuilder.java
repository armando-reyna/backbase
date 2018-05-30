package com.backbase.atm.builder;

import com.backbase.atm.dto.Adress;
import com.backbase.atm.dto.Atm;
import com.backbase.atm.dto.Geolocation;

public class AtmBuilder {

    public static Atm buildAtm() {
        Atm atm = new Atm();
        atm.setType("ING");
        atm.setDistance(0L);
        Adress adress = new Adress();
        adress.setCity("Aalsmeer");
        adress.setStreet("Poldermeesterplein 1");
        adress.setHousenumber("5");
        adress.setPostalcode("1432 JZ");
        Geolocation geolocation = new Geolocation();
        geolocation.setLat(51.778547);
        geolocation.setLng(4.617146);
        adress.setGeoLocation(geolocation);
        atm.setAddress(adress);
        return atm;
    }

}
