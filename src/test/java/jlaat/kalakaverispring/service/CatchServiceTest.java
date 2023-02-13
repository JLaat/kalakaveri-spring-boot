package jlaat.kalakaverispring.service;

import jlaat.kalakaverispring.model.Catch;
import jlaat.kalakaverispring.repository.CatchRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class CatchServiceTest {
    @Mock
    private CatchRepo catchRepo;
    @InjectMocks
    private CatchService catchService;


    @Test
    void getAllCatches() {
        Catch testCatch = new Catch(1L, 2L, 2L, 1L, 15);
        when(catchRepo.findAll()).thenReturn(List.of(testCatch));

        List<Catch> catches = catchService.getAllCatches();

        assertThat(catches.contains(testCatch));
        assertEquals(catches.size(), 1);
    }

    @Test
    void findCatch() {
        Catch testCatch = new Catch(1L, 2L, 2L, 1L, 15);

        when(catchRepo.findCatchById(any(Long.class))).thenReturn(Optional.of(testCatch));

        Catch catchFound = catchService.findCatch(1L);

        assertEquals(catchFound.getId(), testCatch.getId());
        assertEquals(catchFound.getFishId(), testCatch.getFishId());
        assertEquals(catchFound.getLakeId(), testCatch.getLakeId());
        assertEquals(catchFound.getLureId(), testCatch.getLureId());
        assertEquals(catchFound.getWeight(), testCatch.getWeight());

    }

    @Test
    void addCatch() {
        Catch testCatch = new Catch(1L, 2L, 2L, 1L, 15);

        when(catchRepo.save(any(Catch.class))).then(returnsFirstArg());

        Catch catchAdded = catchService.addCatch(testCatch);

        assertEquals(catchAdded.getId(), testCatch.getId());
        assertEquals(catchAdded.getFishId(), testCatch.getFishId());
        assertEquals(catchAdded.getLakeId(), testCatch.getLakeId());
        assertEquals(catchAdded.getLureId(), testCatch.getLureId());
        assertEquals(catchAdded.getWeight(), testCatch.getWeight());
    }

    @Test
    void updateCatch() {
        Catch testCatch = new Catch(1L, 2L, 2L, 1L, 15);
        when(catchRepo.save(any(Catch.class))).then(returnsFirstArg());

        Catch catchUpdated = catchService.updateCatch(testCatch);

        assertEquals(catchUpdated.getId(), testCatch.getId());
        assertEquals(catchUpdated.getFishId(), testCatch.getFishId());
        assertEquals(catchUpdated.getLakeId(), testCatch.getLakeId());
        assertEquals(catchUpdated.getLureId(), testCatch.getLureId());
        assertEquals(catchUpdated.getWeight(), testCatch.getWeight());
    }
}