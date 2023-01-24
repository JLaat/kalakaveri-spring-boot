package jlaat.kalakaverispring.service;

import jlaat.kalakaverispring.repository.LureRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LureService {
    private final LureRepo lureRepo;

    @Autowired
    public LureService(LureRepo lureRepo) {
        this.lureRepo = lureRepo;
    }
}
