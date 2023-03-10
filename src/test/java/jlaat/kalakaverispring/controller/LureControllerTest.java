package jlaat.kalakaverispring.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
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
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
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
        Lure lure = new Lure(1L, "Rapala", "X-Rap", "Red", 16);
        when(lureService.findLure(any(Long.class))).thenReturn(lure);

        this.mockMvc.perform(get("/lure/find/{id}", 1L))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.brand").value("Rapala"))
                .andExpect(jsonPath("$.model").value("X-Rap"))
                .andExpect(jsonPath("$.color").value("Red"))
                .andExpect(jsonPath("$.weight").value(16));
    }

    @Test
    protected void testAddLure() throws Exception {
        Lure lure = new Lure(1L, "Rapala", "X-Rap", "Red", 16);

        when(lureService.addLure(any(Lure.class))).thenReturn(lure);

        mockMvc.perform(post("/lure/add")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(lure)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.brand").value("Rapala"))
                .andExpect(jsonPath("$.model").value("X-Rap"))
                .andExpect(jsonPath("$.color").value("Red"))
                .andExpect(jsonPath("$.weight").value(16));
    }

    @Test
    protected void testUpdateLure() throws Exception {
        Lure lure = new Lure(1L, "Rapala", "X-Rap", "Red", 16);

        when(lureService.updateLure(any(Lure.class))).thenReturn(lure);

        MvcResult mvcResult = this.mockMvc.perform(put("/lure/update")
                        .contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(lure)))
                .andReturn();

        assertEquals(200, mvcResult.getResponse().getStatus());
        assertEquals(objectMapper.writeValueAsString(lure), mvcResult.getResponse().getContentAsString());
    }

    @Test
    protected void testDeleteLure() throws Exception {
        this.mockMvc.perform(delete("/lure/delete/2"))
                .andExpect(status().isOk());
    }
}