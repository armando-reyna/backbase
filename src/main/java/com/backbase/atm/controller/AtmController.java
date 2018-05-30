package com.backbase.atm.controller;

import com.backbase.atm.dto.Atm;
import com.backbase.atm.service.AtmService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1/atm")
public class AtmController {

    private static final Logger log = Logger.getLogger(AtmController.class);

    @Autowired
    private AtmService atmService;

    @PostMapping
    public ResponseEntity<String> processAtms(@RequestBody String atms) throws IOException {
        atmService.processAtms(atms);
        return ResponseEntity.status(HttpStatus.OK).body("OK");
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Page<Atm>> getAtms(Pageable pageable, @RequestParam(value = "city", required = false) String city) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(atmService.getAtms(pageable, city));
        } catch (Exception ex) {
            log.error("Error", ex);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

}
