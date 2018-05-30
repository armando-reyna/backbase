package com.backbase.atm.service;

import com.backbase.atm.dto.Atm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.IOException;

public interface AtmService {

    void processAtms(String atmsSt) throws IOException;

    Page<Atm> getAtms(Pageable pageable, String city);

}
