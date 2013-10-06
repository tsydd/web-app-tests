package repo;

import domain.TestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.RepositoryDefinition;

import java.util.List;

/**
 * @author Dmitry Tsydzik
 * @since Date: 02.10.13
 */
public interface TestEntityRepository extends JpaRepository<TestEntity, Long> {

    List<TestEntity> findByName(String name);

}
