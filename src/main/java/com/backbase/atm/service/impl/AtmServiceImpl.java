package com.backbase.atm.service.impl;

import com.backbase.atm.dto.Atm;
import com.backbase.atm.repository.AtmRepository;
import com.backbase.atm.service.AtmService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class AtmServiceImpl implements AtmService {

    private static final Logger log = Logger.getLogger(AtmServiceImpl.class);

    @Autowired
    private AtmRepository atmRepository;

    public void processAtms(String atmsSt) throws IOException {
        atmsSt = atmsSt.substring(atmsSt.indexOf('\n') + 1);
        ObjectMapper objectMapper = new ObjectMapper();
        List<Atm> atms = objectMapper.readValue(atmsSt, new TypeReference<List<Atm>>() {});
        for (Atm atm : atms) {
            log.debug("Save Atm " + atm.toString());
            try {
                atmRepository.saveAndFlush(atm);
            } catch (DataIntegrityViolationException ex) {
                log.debug("Atm already exists.");
            }
        }
    }

    public Page<Atm> getAtms(Pageable pageable, String city) {
        if(city != null && !city.equals("")){
            return  atmRepository.findByAddress_CityOrderByAddress_CityAscAddress_StreetAsc(pageable, city);
        } else {
            return  atmRepository.findByOrderByAddress_CityAscAddress_StreetAsc(pageable);
        }
    }

}
