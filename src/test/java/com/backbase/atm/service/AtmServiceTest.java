package com.backbase.atm.service;

import com.backbase.atm.builder.AtmBuilder;
import com.backbase.atm.dto.Atm;
import com.backbase.atm.repository.AtmRepository;
import com.backbase.atm.service.impl.AtmServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.any;

@RunWith(SpringRunner.class)
public class AtmServiceTest {

    @MockBean
    private AtmRepository atmRepository;

    @TestConfiguration
    static class AtmServiceTestContextConfiguration {
        @Bean
        public AtmService atmService() {
            return new AtmServiceImpl();
        }
    }

    @Autowired
    private AtmService atmService;

    @Test
    public void processAtm() throws IOException {
        Atm savedAtm = AtmBuilder.buildAtm();
        savedAtm.setId(1L);
        given(atmRepository.saveAndFlush(any())).willReturn(savedAtm);
        String json = ")]}',\n [{\"address\":{\"street\":\"Friesewal\",\"housenumber\":\"1\",\"postalcode\":\"8011 XE\",\"city\":\"Zwolle\",\"geoLocation\":{\"lat\":\"52.515598\",\"lng\":\"6.093148\"}},\"distance\":0,\"type\":\"ING\"}]";
        atmService.processAtms(json);
    }

    @Test
    public void getAtms() {

        Atm savedAtm = AtmBuilder.buildAtm();
        savedAtm.setId(1L);
        Atm savedAtm2 = AtmBuilder.buildAtm();
        savedAtm.setId(2L);
        List<Atm> atmList = new ArrayList<>();
        atmList.add(savedAtm);
        atmList.add(savedAtm2);

        Pageable pageable = new PageRequest(0, 20);

        Page<Atm> savedAtms = new PageImpl<Atm>(atmList, pageable, atmList.size());

        given(atmRepository.findByOrderByAddress_CityAscAddress_StreetAsc(pageable)).willReturn(savedAtms);
        Page<Atm> atms = atmService.getAtms(pageable, null);

        assertThat(atms.getTotalPages()).isEqualTo(1);
        assertThat(atms.getTotalElements()).isEqualTo(2);
        savedAtm = atms.getContent().get(0);
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
    public void getAtmsByCity() {

        Atm savedAtm = AtmBuilder.buildAtm();
        savedAtm.setId(1L);
        Atm savedAtm2 = AtmBuilder.buildAtm();
        savedAtm.setId(2L);
        List<Atm> atmList = new ArrayList<>();
        atmList.add(savedAtm);
        atmList.add(savedAtm2);

        Pageable pageable = new PageRequest(0, 20);

        Page<Atm> savedAtms = new PageImpl<Atm>(atmList, pageable, atmList.size());

        given(atmRepository.findByAddress_CityOrderByAddress_CityAscAddress_StreetAsc(pageable, "Aalsmeer")).willReturn(savedAtms);
        Page<Atm> atms = atmService.getAtms(pageable, "Aalsmeer");

        assertThat(atms.getTotalPages()).isEqualTo(1);
        assertThat(atms.getTotalElements()).isEqualTo(2);
        savedAtm = atms.getContent().get(0);
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

}
