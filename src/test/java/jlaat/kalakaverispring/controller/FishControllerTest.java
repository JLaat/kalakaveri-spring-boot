package jlaat.kalakaverispring.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jlaat.kalakaverispring.model.Fish;
import jlaat.kalakaverispring.service.FishService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(FishController.class)
class FishControllerTest {
    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private FishService fishService;
    @Autowired
    private MockMvc mockMvc;

    @Test
    void getAllFishes() throws Exception {
        mockMvc.perform(get("/fish/all"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    void getFishById() throws Exception {
        Fish fish = new Fish(1L, "Roach");

        when(fishService.findFish(any(Long.class))).thenReturn(fish);

        mockMvc.perform(get("/fish/find/{id}", 1L))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    void addFish() throws Exception {
        Fish fish = new Fish(1L, "Roach");

        when(fishService.addFish(any(Fish.class))).thenReturn(fish);

        mockMvc.perform(post("/fish/add")
                        .content(objectMapper.writeValueAsString(fish))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    void updateFish() throws Exception {
        Fish fish = new Fish(1L, "Roach");

        when(fishService.updateFish(any(Fish.class))).thenReturn(fish);

        mockMvc.perform(put("/fish/update")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(fish)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    void deleteFish() throws Exception {
        mockMvc.perform(delete("/fish/delete/{id}", 1L))
                .andExpect(status().isOk());
    }
}