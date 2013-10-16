package web.controllers;

import com.google.common.collect.Lists;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import service.api.UserService;
import service.dto.UserDto;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

/**
 * @author Dmitry Tsydzik
 * @since Date: 16.10.13
 */
@RunWith(MockitoJUnitRunner.class)
public class UserControllerTest {

    private UserController userController;

    @Before
    public void setUpController() {
        userController = new UserController();
        UserService userService = mock(UserService.class);
        when(userService.findAll()).thenReturn(Lists.newArrayList(new UserDto()));
        userController.userService = userService;
    }

    @Test
    public void testUserList() throws Exception {
        standaloneSetup(userController).build()
                .perform(get("/users"))
                .andDo(print())
                .andExpect(status().isOk());
    }
}
