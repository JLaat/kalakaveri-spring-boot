package jlaat.kalakaverispring.service;

import jakarta.transaction.Transactional;
import jlaat.kalakaverispring.model.Catch;
import jlaat.kalakaverispring.repository.CatchRepo;
import jlaat.kalakaverispring.repository.CatchRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class CatchService {
    private final CatchRepo catchRepo;

    @Autowired
    public CatchService(CatchRepo catchRepo) {this.catchRepo = catchRepo;}

    public List<Catch> getAllCatches() {
        return catchRepo.findAll();
    }

    public long getCatchesByFish(Long id) {
        return catchRepo.countByFishId(id);
    }

    public Catch findCatch(Long id) {
        return catchRepo.findCatchById(id).orElseThrow(() -> new RuntimeException("Catch by id "+id+" was not found."));
    }

    public Catch addCatch(Catch catched) {
        return catchRepo.save(catched);
    }

    public Catch updateCatch(Catch catched) {
        return catchRepo.save(catched);
    }

    public void deleteFishById(Long id) {
        catchRepo.deleteFishById(id);
    }

    public List<Catch> getTopCatches() {
        return catchRepo.getTopCatches();
    }
}
