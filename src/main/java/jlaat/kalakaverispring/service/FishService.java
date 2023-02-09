package jlaat.kalakaverispring.service;

import jakarta.transaction.Transactional;
import jlaat.kalakaverispring.model.Fish;
import jlaat.kalakaverispring.repository.FishRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class FishService {
    private final FishRepo fishRepo;

    public FishService(FishRepo fishRepo) {
        this.fishRepo = fishRepo;
    }

    public List<Fish> findAllFishes() {
        return fishRepo.findAll();
    }

    public Fish addFish(Fish fish) {
        return fishRepo.save(fish);
    }

    public Fish updateFish(Fish fish) {
        return fishRepo.save(fish);
    }

    public Fish findFish(Long id) {
        return fishRepo.findFishById(id).orElseThrow(() -> new IllegalStateException("Fish by id " + id + " was not found"));
    }

    public void deleteFish(Long id) {
        fishRepo.deleteFishById(id);
    }
}
