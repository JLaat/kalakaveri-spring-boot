package jlaat.kalakaverispring.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import jlaat.kalakaverispring.service.LakeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.core.AutoConfigureCache;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvc.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(LakeController.class)
class LakeControllerTest {

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private LakeService lakeService;
    @Autowired
    protected MockMvc mockMvc;


    @Test
    void getAll() throws Exception {
        this.mockMvc.perform(get("/lake/all"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    void findLake() {

    }

    @Test
    void addLake() {
    }

    @Test
    void updateLake() {
    }

    @Test
    void deleteLake() {
    }
}