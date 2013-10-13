package domain;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;

import static org.junit.Assert.assertNotNull;

/**
 * @author Dmitry Tsydzik
 * @since Date: 02.10.13
 */
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration("classpath:hibernate.xml")
public class SessionFactoryTest {

    @PersistenceContext
    private EntityManager entityManager;

    @Test
    public void test() {
        TestEntity testEntity = new TestEntity();
        entityManager.persist(testEntity);
        assertNotNull(testEntity.getId());
    }
}
