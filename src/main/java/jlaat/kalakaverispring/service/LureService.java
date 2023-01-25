package jlaat.kalakaverispring.service;

import jakarta.transaction.Transactional;
import jlaat.kalakaverispring.model.Lure;
import jlaat.kalakaverispring.repository.LureRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class LureService {
    private final LureRepo lureRepo;

    @Autowired
    public LureService(LureRepo lureRepo) {
        this.lureRepo = lureRepo;
    }

    public List<Lure> getAllLures() {
        return lureRepo.findAll();
    }

    public Lure findLure(Long id) {
        return lureRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Lure with id " + id + " was not found."));
    }

    public Lure addLure(Lure lure) {
        return lureRepo.save(lure);
    }

    public Lure updateLure(Lure lure) {
        return lureRepo.save(lure);
    }

    public void deleteLure(Long id) {
        lureRepo.deleteById(id);
    }
}
