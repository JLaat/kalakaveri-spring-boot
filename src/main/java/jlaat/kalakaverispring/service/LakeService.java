package jlaat.kalakaverispring.service;

import jakarta.transaction.Transactional;
import jlaat.kalakaverispring.model.Lake;
import jlaat.kalakaverispring.repository.LakeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class LakeService {
    private final LakeRepo lakeRepo;

    @Autowired
    public LakeService(LakeRepo lakeRepo) {
        this.lakeRepo = lakeRepo;
    }

    public List<Lake> getAllLakes() {
        return lakeRepo.findAll();
    }

    public Optional<Lake> findLake(Long id) {
        return lakeRepo.findLakeById(id);
    }

    public Lake addLake(Lake lake) {
        return lakeRepo.save(lake);
    }

    public Lake updateLake(Lake lake) {
        return lakeRepo.save(lake);
    }

    public void deleteLake(Long id) {
        lakeRepo.deleteLakeById(id);
    }
}
