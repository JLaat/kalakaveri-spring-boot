package jlaat.kalakaverispring.repository;

import jlaat.kalakaverispring.model.Catch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Repository
public interface CatchRepo extends JpaRepository<Catch, Long> {
    Optional<Catch> findCatchById(Long id);

    void deleteFishById(Long id);

    @Query(value = "SELECT * FROM catch ORDER BY weight desc LIMIT 10", nativeQuery = true)
    List<Catch> getTopCatches();

    Long countByFishId(Long id);

    Long countByLureId(Long id);

    @Query("SELECT SUM(c.weight) FROM Catch c WHERE c.lureId = :lureId")
    Double sumWeightByLure(@Param("lureId") Long id);
}
