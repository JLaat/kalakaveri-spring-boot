package jlaat.kalakaverispring.repository;

import jlaat.kalakaverispring.model.Catch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CatchRepo extends JpaRepository<Catch, Long> {
    Optional<Catch> findCatchById(Long id);

    void deleteFishById(Long id);
}
