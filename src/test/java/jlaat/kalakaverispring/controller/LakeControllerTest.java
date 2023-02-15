package jlaat.kalakaverispring.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import jlaat.kalakaverispring.model.Lake;
import jlaat.kalakaverispring.service.LakeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvc.*;
import org.springframework.test.web.servlet.MvcResult;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
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
        Lake testLake = new Lake(1L, "Pyhäselkä", "Joensuu");

        when(lakeService.getAllLakes()).thenReturn(List.of(testLake));

        this.mockMvc.perform(get("/lake/all"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.[0].id").value(1L))
                .andExpect(jsonPath("$.[0].location").value("Joensuu"))
                .andExpect(jsonPath("$.[0].name").value("Pyhäselkä"));
    }

    @Test
    void findLake() throws Exception {
        Long id = 1L;
        Lake lake = new Lake(id, "Pyhäselkä", "Joensuu");

        when(this.lakeService.findLake(1L)).thenReturn(lake);

        this.mockMvc.perform(get("/lake/find/{id}", id))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.location").value("Joensuu"))
                .andExpect(jsonPath("$.name").value("Pyhäselkä"));;
    }

    @Test
    void addLake() throws Exception {
        Lake lake = new Lake(1L, "Aittolampi", "Joensuu");

        when(lakeService.addLake(any(Lake.class))).thenReturn(lake);

        mockMvc.perform(post("/lake/add")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(lake)))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.location").value("Joensuu"))
                .andExpect(jsonPath("$.name").value("Aittolampi"))
                .andExpect(jsonPath("$.id").value(1L));

    }

    @Test
    void updateLake() throws Exception {
        Lake lake = new Lake(1L, "Aittolampi", "Joensuu");

        when(lakeService.updateLake(any())).thenReturn(lake);

        MvcResult mvcResult = mockMvc.perform(put("/lake/update")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(lake)))
                .andExpect(jsonPath("$.location").value("Joensuu"))
                .andExpect(jsonPath("$.name").value("Aittolampi"))
                .andExpect(jsonPath("$.id").value(1L))
                .andReturn();

        assertEquals(mvcResult.getResponse().getStatus(), 200);
        assertEquals(mvcResult.getResponse().getContentAsString(), objectMapper.writeValueAsString(lake));
    }

    @Test
    void deleteLake() throws Exception {
        mockMvc.perform(delete("/lake/delete/{id}", 1L))
                .andExpect(status().isOk());
    }
}