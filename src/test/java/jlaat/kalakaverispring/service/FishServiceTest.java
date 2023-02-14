package jlaat.kalakaverispring.service;

import jlaat.kalakaverispring.model.Fish;
import jlaat.kalakaverispring.repository.FishRepo;
import org.junit.jupiter.api.BeforeEach;
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
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FishServiceTest {
    @Mock
    private FishRepo fishRepo;
    @InjectMocks
    private FishService fishService;

    @Test
    void findAllFishes() {
        Fish fish = new Fish(1L, "Pike");
        Fish fish2 = new Fish(2L, "Perch");

        List<Fish> fishes = List.of(fish, fish2);

        when(fishRepo.findAll()).thenReturn(fishes);

        List<Fish> fishesFound = fishService.findAllFishes();

        assertEquals(fishesFound.size(), fishes.size());
        assertEquals(fishesFound, fishes);

    }

    @Test
    void addFish() {
        Fish fish = new Fish(1L, "Pike");

        when(fishRepo.save(any(Fish.class))).then(returnsFirstArg());

        Fish fishAdded = fishService.addFish(fish);

        assertEquals(fish, fishAdded);
    }

    @Test
    void updateFish() {
        Fish fish = new Fish(1L, "Pike");

        when(fishRepo.save(any(Fish.class))).then(returnsFirstArg());

        Fish fishUpdated = fishService.addFish(fish);

        assertEquals(fish, fishUpdated);
    }

    @Test
    void findFish() {
        Fish fish = new Fish(1L, "Pike");

        when(fishRepo.findFishById(any(Long.class))).thenReturn(Optional.of(fish));

        Fish fishFound = fishService.findFish(1L);

        assertEquals(fish.getId(), fishFound.getId());
        assertEquals(fish.getName(), fishFound.getName());
    }
}