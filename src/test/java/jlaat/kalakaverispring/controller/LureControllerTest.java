package jlaat.kalakaverispring.controller;

import jlaat.kalakaverispring.model.Fish;
import jlaat.kalakaverispring.model.Lure;
import jlaat.kalakaverispring.service.LureService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(LureController.class)
class LureControllerTest {
    @MockBean
    private LureService lureService;
    @Autowired
    MockMvc mockMvc;

    @Test
    void testGetAllLures() throws Exception {
        this.mockMvc.perform(get("/lure/all")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }
    @Test
    void testFindLure() {
    }

    @Test
    void testAddLure() throws Exception {

    }

    @Test
    void testUpdateLure() {
    }

    @Test
    void testDeleteLure() {
    }
}