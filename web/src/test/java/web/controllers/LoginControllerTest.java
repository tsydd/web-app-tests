package web.controllers;

import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;
import org.springframework.http.MediaType;
import web.dto.LoginRequestDto;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;


/**
 * @author Dmitry Tsydzik
 * @since Date: 12.10.13
 */
public class LoginControllerTest {

    @Test
    public void loginTest() throws Exception {
        LoginRequestDto data = new LoginRequestDto();
        data.setUserName("some email");
        data.setPassword("some password");

        standaloneSetup(new LoginController()).build()
                .perform(post("/login")
                        .content(new ObjectMapper().writeValueAsString(data))
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.userName").value(data.getUserName()))
                .andExpect(jsonPath("$.password").value(data.getPassword()));
    }

}
