package service.converter.assembler;

import domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import service.dto.UserDto;

import static org.junit.Assert.assertEquals;

/**
 * @author Dmitry Tsydzik
 * @since Date: 13.10.13
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:converters.xml")
public class UserAssemblerTest {

    @Autowired
    private UserAssembler userAssembler;

    @Test
    public void assemblerTest() {
        UserDto userDto = new UserDto();
        userDto.setEmail("email");
        userDto.setPassword("password");
        userDto.setId(-1L);

        User user = userAssembler.convert(userDto);

        assertEquals(userDto.getId(), user.getId());
        assertEquals(userDto.getEmail(), user.getEmail());
    }
}
