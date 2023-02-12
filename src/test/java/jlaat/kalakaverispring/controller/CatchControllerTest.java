package jlaat.kalakaverispring.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import jlaat.kalakaverispring.model.Catch;
import jlaat.kalakaverispring.service.CatchService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
        this.mockMvc.perform(get("/catch/all"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    void getTopCatches() throws Exception {
        this.mockMvc.perform(get("/catch/top"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    void getCountByFish() throws Exception {
        this.mockMvc.perform(get("/catch/count/2"))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    void findCatch() throws Exception {
        when(catchService.findCatch(any(Long.class))).thenReturn(new Catch());

        this.mockMvc.perform(get("/catch/find/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    void addCatch() throws Exception {
        Catch newCatch = new Catch(1L, 2L, 2L, 18);

        when(catchService.addCatch(any(Catch.class))).thenReturn(newCatch);

        this.mockMvc.perform(post("/catch/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(newCatch)))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    void updateCatch() throws Exception {
        Catch newCatch = new Catch(1L, 2L, 2L, 18);

        when(catchService.updateCatch(any(Catch.class))).thenReturn(newCatch);

        this.mockMvc.perform(put("/catch/update")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(newCatch)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    void deleteCatch() throws Exception {
        this.mockMvc.perform(delete("/catch/delete/1"))
                .andExpect(status().isOk());
    }
}