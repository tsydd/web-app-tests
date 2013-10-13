package service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import service.api.UserService;
import service.dto.UserDto;

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
        UserDto userDto = new UserDto();
        userDto.setEmail("email");
        userDto.setPassword("password");

        UserDto saved = userService.save(userDto);

        assertNotNull(saved.getId());
    }

}
