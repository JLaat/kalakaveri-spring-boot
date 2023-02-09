package jlaat.kalakaverispring.service;

import jakarta.transaction.Transactional;
import jlaat.kalakaverispring.model.Lake;
import jlaat.kalakaverispring.repository.LakeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class LakeService {
    private final LakeRepo lakeRepo;

    public LakeService(LakeRepo lakeRepo) {
        this.lakeRepo = lakeRepo;
    }

    public List<Lake> getAllLakes() {
        return lakeRepo.findAll();
    }

    public Lake findLake(Long id) {
        return lakeRepo.findLakeById(id).orElseThrow(() -> new RuntimeException("Lake with id " + id + " was not found"));
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
