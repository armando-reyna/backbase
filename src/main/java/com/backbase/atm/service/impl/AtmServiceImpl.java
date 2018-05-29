package com.backbase.atm.service.impl;

import com.backbase.atm.dto.AtmDTO;
import com.backbase.atm.service.AtmService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class AtmServiceImpl implements AtmService {

    private static final Logger log = Logger.getLogger(AtmServiceImpl.class);

    public void processAtms(String atmsSt) throws IOException {
        atmsSt = atmsSt.substring(atmsSt.indexOf('\n') + 1);
        ObjectMapper objectMapper = new ObjectMapper();
        List<AtmDTO> atms = objectMapper.readValue(atmsSt, new TypeReference<List<AtmDTO>>() {});
        for (AtmDTO atm : atms) {
            log.info(atm);
        }

    }

}
