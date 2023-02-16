package jlaat.kalakaverispring.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestPropertySource(
        properties = {
                "spring.datasource.url=jdbc:tc:mariadb:10.3.6:///kalakaveri"
        }
)
class CatchRepoTest {
    @Autowired
    private CatchRepo catchRepo;
    @Autowired
    private TestEntityManager testEntityManager;

    @Test
    void findCatchById() {
    }

    @Test
    void deleteFishById() {
    }

    @Test
    void getTopCatches() {
    }

    @Test
    void countByFishId() {
    }

    @Test
    void countByLureId() {
    }

    @Test
    void sumWeightByLure() {
    }
}