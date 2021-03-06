package repo;

import domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @author Dmitry Tsydzik
 * @since Date: 13.10.13
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:hibernate.xml")
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testCreate() {
        User user = new User();
        user.setEmail("email");
        user.setPassword("password");
        userRepository.save(user);

        assertNotNull(user.getId());
        assertEquals(1, userRepository.count());
    }
}
