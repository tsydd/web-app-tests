package service.impl;

import domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import service.api.UserService;

import static org.junit.Assert.assertNotNull;

/**
 * @author Dmitry Tsydzik
 * @since Date: 13.10.13
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:service-impl.xml")
public class UserServiceImplTest {

    @Autowired
    private UserService userService;

    @Test
    public void testCreate() {
        User user = new User();
        user.setEmail("email");
        user.setPassword("password");

        User saved = userService.save(user);

        assertNotNull(saved.getId());
    }
}
