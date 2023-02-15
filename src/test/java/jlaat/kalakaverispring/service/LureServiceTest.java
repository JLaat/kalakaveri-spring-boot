package jlaat.kalakaverispring.service;

import jlaat.kalakaverispring.model.Lure;
import jlaat.kalakaverispring.repository.LureRepo;
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
class LureServiceTest {
    @Mock
    private LureRepo lureRepo;
    @InjectMocks
    private LureService lureService;

    @Test
    void getAllLures() {
        Lure testLure = new Lure(1L, "Rapala", "X-Rap", "Red", 13);
        Lure testLure2 = new Lure(1L, "Rapala", "X-Rap", "Blue", 13);

        List<Lure> testLures = List.of(testLure, testLure2);

        when(lureRepo.findAll()).thenReturn(testLures);

        List<Lure> foundLures =  lureService.getAllLures();

        assertEquals(testLures, foundLures);
    }

    @Test
    void findLure() {
        Lure testLure = new Lure(1L, "Rapala", "X-Rap", "Red", 13);

        when(lureRepo.findLureById(any(Long.class))).thenReturn(Optional.of(testLure));

        Lure foundLure = lureService.findLure(1L);

        assertEquals(foundLure.getId(), testLure.getId());
    }

    @Test
    void addLure() {
        Lure testLure = new Lure(1L, "Rapala", "X-Rap", "Red", 13);

        when(lureRepo.save(any(Lure.class))).then(returnsFirstArg());

        Lure addedLure = lureService.addLure(testLure);

        assertEquals(testLure, addedLure);
    }

    @Test
    void updateLure() {
        Lure testLure = new Lure(1L, "Rapala", "X-Rap", "Red", 13);

        when(lureRepo.save(any(Lure.class))).then(returnsFirstArg());

        Lure updatedLure = lureService.addLure(testLure);

        assertEquals(testLure, updatedLure);
    }
}