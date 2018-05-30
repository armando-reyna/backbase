package com.backbase.atm.controller;

import com.backbase.atm.builder.AtmBuilder;
import com.backbase.atm.dto.Atm;
import com.backbase.atm.service.AtmService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest
public class AtmControllerTest {

    @Autowired
    private WebApplicationContext context;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AtmService atmService;

    @MockBean
    private UserDetailsService userDetailsService;

    private UserDetails userDetails;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(context)
                .apply(springSecurity())
                .build();
        userDetails = userDetailsService.loadUserByUsername("armando");
    }

    public static String asJsonString(final Object obj) {
        try {
            final ObjectMapper mapper = new ObjectMapper();
            final String jsonContent = mapper.writeValueAsString(obj);
            return jsonContent;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void returnUnauthorized() throws Exception {

        Atm savedAtm = AtmBuilder.buildAtm();
        savedAtm.setId(1L);
        Atm savedAtm2 = AtmBuilder.buildAtm();
        savedAtm.setId(2L);
        List<Atm> atmList = new ArrayList<>();
        atmList.add(savedAtm);
        atmList.add(savedAtm2);

        Pageable pageable = new PageRequest(0, 20);

        Page<Atm> savedAtms = new PageImpl<Atm>(atmList, pageable, atmList.size());

        when(this.atmService.getAtms(pageable, null)).thenReturn(savedAtms);

        this.mockMvc.perform(get("/api/v1/atm"))
                .andExpect(status().isUnauthorized());
    }

}
