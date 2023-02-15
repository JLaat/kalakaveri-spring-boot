package jlaat.kalakaverispring.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import jlaat.kalakaverispring.model.Catch;
import jlaat.kalakaverispring.service.CatchService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(CatchController.class)
class CatchControllerTest {

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private CatchService catchService;
    @Autowired
    private MockMvc mockMvc;

    @Test
    void getAllCatches() throws Exception {
        Catch testCatch = new Catch(1L, 2L, 3L, 4L, 15);

        when(catchService.getAllCatches()).thenReturn(List.of(testCatch));

        this.mockMvc.perform(get("/catch/all"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.[0].id").value(1L))
                .andExpect(jsonPath("$.[0].fishId").value(2L))
                .andExpect(jsonPath("$.[0].lakeId").value(3L))
                .andExpect(jsonPath("$.[0].lureId").value(4L))
                .andExpect(jsonPath("$.[0].weight").value(15));
    }

    @Test
    void getTopCatches() throws Exception {
        Catch testCatch = new Catch(1L, 2L, 3L, 4L, 15);

        when(catchService.getTopCatches()).thenReturn(List.of(testCatch));

        this.mockMvc.perform(get("/catch/top"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.[0].id").value(1L))
                .andExpect(jsonPath("$.[0].fishId").value(2L))
                .andExpect(jsonPath("$.[0].lakeId").value(3L))
                .andExpect(jsonPath("$.[0].lureId").value(4L))
                .andExpect(jsonPath("$.[0].weight").value(15));
    }

    @Test
    void getCountByFish() throws Exception {
        when(catchService.getCatchesByFish(2L)).thenReturn(13L);

        this.mockMvc.perform(get("/catch/count/{id}", 2L))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    void findCatch() throws Exception {
        Catch testCatch = new Catch(1L, 2L, 3L, 4L, 15);
        when(catchService.findCatch(any(Long.class))).thenReturn(testCatch);

        this.mockMvc.perform(get("/catch/find/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.fishId").value(2L))
                .andExpect(jsonPath("$.lakeId").value(3L))
                .andExpect(jsonPath("$.lureId").value(4L))
                .andExpect(jsonPath("$.weight").value(15));
    }

    @Test
    void addCatch() throws Exception {
        Catch testCatch = new Catch(1L, 2L, 3L, 4L, 15);

        when(catchService.addCatch(any(Catch.class))).thenReturn(testCatch);

        this.mockMvc.perform(post("/catch/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(testCatch)))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.fishId").value(2L))
                .andExpect(jsonPath("$.lakeId").value(3L))
                .andExpect(jsonPath("$.lureId").value(4L))
                .andExpect(jsonPath("$.weight").value(15));
    }

    @Test
    void updateCatch() throws Exception {
        Catch testCatch = new Catch(1L, 2L, 3L, 4L, 15);

        when(catchService.updateCatch(any(Catch.class))).thenReturn(testCatch);

        this.mockMvc.perform(put("/catch/update")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(testCatch)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.fishId").value(2L))
                .andExpect(jsonPath("$.lakeId").value(3L))
                .andExpect(jsonPath("$.lureId").value(4L))
                .andExpect(jsonPath("$.weight").value(15));
    }

    @Test
    void deleteCatch() throws Exception {
        this.mockMvc.perform(delete("/catch/delete/1"))
                .andExpect(status().isOk());
    }
}