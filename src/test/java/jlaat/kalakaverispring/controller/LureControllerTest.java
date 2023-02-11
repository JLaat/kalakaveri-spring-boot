package jlaat.kalakaverispring.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import jlaat.kalakaverispring.model.Fish;
import jlaat.kalakaverispring.model.Lure;
import jlaat.kalakaverispring.service.LureService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest(LureController.class)
class LureControllerTest {

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private LureService lureService;
    @Autowired
    protected MockMvc mockMvc;

    @Test
    protected void testGetAllLures() throws Exception {
        this.mockMvc.perform(get("/lure/all")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    protected void testFindLure() throws Exception {
        Long id = 2L;
        when(lureService.findLure(2L)).thenReturn(new Lure("Rapala", "X-Rap", "Red", 13));

        this.mockMvc.perform(get("/lure/find/{id}", id)).andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    protected void testAddLure() throws Exception {
        Lure lure = new Lure(1L, "Rapala", "X-Rap", "Red", 16);

        mockMvc.perform(post("/lure/add")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(lure)))
                .andExpect(status().isCreated());
    }

    @Test
    protected void testUpdateLure() {
    }

    @Test
    protected void testDeleteLure() {
    }
}