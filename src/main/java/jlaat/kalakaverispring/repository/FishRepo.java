package jlaat.kalakaverispring.repository;

import jlaat.kalakaverispring.model.Fish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FishRepo extends JpaRepository<Fish, Long> {
}
