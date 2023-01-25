package jlaat.kalakaverispring.repository;

import jlaat.kalakaverispring.model.Fish;
import jlaat.kalakaverispring.model.Lake;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface LakeRepo extends JpaRepository<Lake, Long> {
    Optional<Lake> findLakeById(Long id);

    void deleteLakeById(Long id);
}
