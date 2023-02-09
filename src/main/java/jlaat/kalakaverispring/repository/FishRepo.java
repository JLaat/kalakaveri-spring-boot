package jlaat.kalakaverispring.repository;

import jlaat.kalakaverispring.model.Fish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FishRepo extends JpaRepository<Fish, Long> {
    Optional<Fish> findFishById(Long id);

    void deleteFishById(Long id);

}
