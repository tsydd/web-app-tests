package repo;

import domain.TestEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

/**
 * @author Dmitry Tsydzik
 * @since Date: 02.10.13
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:hibernate.xml")
@Transactional
public class RepoTest {

    @Autowired
    private TestEntityRepository testEntityRepository;

    @Test
    public void test() {
        TestEntity testEntity = new TestEntity("asd");
        testEntityRepository.save(testEntity);
//        testEntityRepository.
        assertNotNull(testEntity.getId());
        assertFalse(testEntityRepository.findByName("asd").isEmpty());
    }
}
