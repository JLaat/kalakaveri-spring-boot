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
        this.mockMvc.perform(get("/lake/all"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    void findLake() throws Exception {
        Long id = 1L;
        Lake lake = new Lake(id, "Joensuu", "Aittolampi");

        when(this.lakeService.findLake(1L)).thenReturn(lake);

        this.mockMvc.perform(get("/lake/find/{id}", id))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    void addLake() throws Exception {
        Lake lake = new Lake(1L, "Joensuu", "Aittolampi");

        when(lakeService.addLake(any(Lake.class))).thenReturn(lake);

        mockMvc.perform(post("/lake/add")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(lake)))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));

    }

    @Test
    void updateLake() throws Exception {
        Lake lake = new Lake(1L, "Joensuu", "Aittolampi");

        when(lakeService.updateLake(any())).thenReturn(lake);

        MvcResult mvcResult = mockMvc.perform(put("/lake/update")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(lake)))
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