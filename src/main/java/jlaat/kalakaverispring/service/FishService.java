package jlaat.kalakaverispring.service;

import jlaat.kalakaverispring.repository.FishRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FishService {
    private final FishRepo fishRepo;

    @Autowired
    public FishService(FishRepo fishRepo) {
        this.fishRepo = fishRepo;
    }
}
