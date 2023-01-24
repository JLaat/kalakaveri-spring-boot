package jlaat.kalakaverispring.repository;

import jlaat.kalakaverispring.model.Lake;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LakeRepo extends JpaRepository<Lake, Long> {
}
