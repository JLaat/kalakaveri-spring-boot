package jlaat.kalakaverispring.service;

import jlaat.kalakaverispring.repository.LakeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LakeService {
    private final LakeRepo lakeRepo;

    @Autowired
    public LakeService(LakeRepo lakeRepo) {
        this.lakeRepo = lakeRepo;
    }
}
