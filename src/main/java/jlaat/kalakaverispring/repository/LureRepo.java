package jlaat.kalakaverispring.repository;

import jlaat.kalakaverispring.model.Lure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LureRepo extends JpaRepository<Lure, Long> {
    Optional<Lure> findLureById(Long id);
}
