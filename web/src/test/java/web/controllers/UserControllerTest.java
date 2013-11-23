package web.controllers;

import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;
import org.kubek2k.springockito.annotations.ReplaceWithMock;
import org.kubek2k.springockito.annotations.SpringockitoAnnotatedContextLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import ws.api.UserWebService;
import ws.model.user.UserSaveRequest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

/**
 * @author Dmitry Tsydzik
 * @since Date: 16.10.13
 */
@ContextConfiguration(
        loader = SpringockitoAnnotatedContextLoader.class,
        classes = UserController.class
)
public class UserControllerTest extends AbstractJUnit4SpringContextTests {

    @Autowired
    private UserController userController;

    @SuppressWarnings({"SpringJavaAutowiringInspection", "UnusedDeclaration"})
    @Autowired
    @ReplaceWithMock
    private UserWebService userService;

    @Test
    public void testUserList() throws Exception {
        standaloneSetup(userController).build()
                .perform(get("/users"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void testSaveUser() throws Exception {
        UserSaveRequest data = new UserSaveRequest();
        data.setEmail("email");
        standaloneSetup(userController).build()
                .perform(post("/users")
                        .content(new ObjectMapper().writeValueAsString(data))
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }
}
