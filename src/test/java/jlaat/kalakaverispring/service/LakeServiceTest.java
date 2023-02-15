package jlaat.kalakaverispring.service;

import jlaat.kalakaverispring.model.Fish;
import jlaat.kalakaverispring.model.Lake;
import jlaat.kalakaverispring.repository.LakeRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class LakeServiceTest {
    @Mock
    private LakeRepo lakeRepo;
    @InjectMocks
    private LakeService lakeService;

    @Test
    void getAllLakes() {
        Lake testLake = new Lake(1L, "Pyhäselkä", "Joensuu");
        Lake testLake2 = new Lake(2L, "Höytiäinen", "Kontiolahti");
        List<Lake> testLakes = List.of(testLake, testLake2);

        when(lakeRepo.findAll()).thenReturn(testLakes);

        List<Lake> foundLakes = lakeService.getAllLakes();

        assertEquals(foundLakes, testLakes);
    }

    @Test
    void findLake() {
        Lake testLake = new Lake(1L, "Pyhäselkä", "Joensuu");

        when(lakeRepo.findLakeById(any(Long.class))).thenReturn(Optional.of(testLake));

        Lake foundLake = lakeService.findLake(1L);

        assertEquals(foundLake.getId(), testLake.getId());
        assertEquals(foundLake.getName(), testLake.getName());
        assertEquals(foundLake.getLocation(), testLake.getLocation());
    }

    @Test
    void addLake() {
        Lake testLake = new Lake(1L, "Pyhäselkä", "Joensuu");

        when(lakeRepo.save(any(Lake.class))).then(returnsFirstArg());

        Lake addedLake = lakeService.addLake(testLake);

        assertEquals(addedLake, testLake);
    }

    @Test
    void updateLake() {
        Lake testLake = new Lake(1L, "Pyhäselkä", "Joensuu");

        when(lakeRepo.save(any(Lake.class))).then(returnsFirstArg());

        Lake updatedLake = lakeService.addLake(testLake);

        assertEquals(updatedLake, testLake);
    }
}