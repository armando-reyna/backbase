package com.backbase.atm.repository;

import com.backbase.atm.builder.AtmBuilder;
import com.backbase.atm.dto.Adress;
import com.backbase.atm.dto.Atm;
import com.backbase.atm.dto.Geolocation;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AtmRepositoryTest {

    @Autowired
    private AtmRepository atmRepository;

    @Test
    public void a_createAtm() {

        Atm atm = AtmBuilder.buildAtm();

        Atm savedAtm = this.atmRepository.saveAndFlush(atm);

        assertThat(savedAtm.getId()).isEqualTo(1L);
        assertThat(savedAtm.getType()).isEqualTo("ING");
        assertThat(savedAtm.getDistance()).isEqualTo(0L);
        assertThat(savedAtm.getAddress().getCity()).isEqualTo("Aalsmeer");
        assertThat(savedAtm.getAddress().getStreet()).isEqualTo("Poldermeesterplein 1");
        assertThat(savedAtm.getAddress().getHousenumber()).isEqualTo("5");
        assertThat(savedAtm.getAddress().getPostalcode()).isEqualTo("1432 JZ");
        assertThat(savedAtm.getAddress().getGeoLocation().getLat()).isEqualTo(51.778547);
        assertThat(savedAtm.getAddress().getGeoLocation().getLng()).isEqualTo(4.617146);

    }

    @Test
    public void b_getAtms() {

        Atm atm = AtmBuilder.buildAtm();

        this.atmRepository.saveAndFlush(atm);

        Pageable pageable = new PageRequest(0, 20);

        Page<Atm> atms = this.atmRepository.findByOrderByAddress_CityAscAddress_StreetAsc(pageable);

        assertThat(atms.getTotalPages()).isEqualTo(1);
        assertThat(atms.getTotalElements()).isEqualTo(1);
        Atm savedAtm = atms.getContent().get(0);
        assertThat(savedAtm.getId()).isEqualTo(2L);
        assertThat(savedAtm.getType()).isEqualTo("ING");
        assertThat(savedAtm.getDistance()).isEqualTo(0L);
        assertThat(savedAtm.getAddress().getCity()).isEqualTo("Aalsmeer");
        assertThat(savedAtm.getAddress().getStreet()).isEqualTo("Poldermeesterplein 1");
        assertThat(savedAtm.getAddress().getHousenumber()).isEqualTo("5");
        assertThat(savedAtm.getAddress().getPostalcode()).isEqualTo("1432 JZ");
        assertThat(savedAtm.getAddress().getGeoLocation().getLat()).isEqualTo(51.778547);
        assertThat(savedAtm.getAddress().getGeoLocation().getLng()).isEqualTo(4.617146);

    }

    @Test
    public void c_getAtmsByCity() {

        Atm atm = AtmBuilder.buildAtm();

        this.atmRepository.saveAndFlush(atm);

        Pageable pageable = new PageRequest(0, 20);

        Page<Atm> atms = this.atmRepository.findByAddress_CityOrderByAddress_CityAscAddress_StreetAsc(pageable, "Aalsmeer");

        assertThat(atms.getTotalPages()).isEqualTo(1);
        assertThat(atms.getTotalElements()).isEqualTo(1);
        Atm savedAtm = atms.getContent().get(0);
        assertThat(savedAtm.getId()).isEqualTo(3L);
        assertThat(savedAtm.getType()).isEqualTo("ING");
        assertThat(savedAtm.getDistance()).isEqualTo(0L);
        assertThat(savedAtm.getAddress().getCity()).isEqualTo("Aalsmeer");
        assertThat(savedAtm.getAddress().getStreet()).isEqualTo("Poldermeesterplein 1");
        assertThat(savedAtm.getAddress().getHousenumber()).isEqualTo("5");
        assertThat(savedAtm.getAddress().getPostalcode()).isEqualTo("1432 JZ");
        assertThat(savedAtm.getAddress().getGeoLocation().getLat()).isEqualTo(51.778547);
        assertThat(savedAtm.getAddress().getGeoLocation().getLng()).isEqualTo(4.617146);


    }

}
