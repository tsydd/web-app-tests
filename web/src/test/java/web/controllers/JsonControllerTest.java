package web.controllers;

import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

/**
 * @author Dmitry Tsydzik
 * @since Date: 13.10.13
 */
public class JsonControllerTest {

    @RestController
    public static class JsonController {

        @RequestMapping("/")
        public JsonObject someMethod(@RequestBody JsonObject value) {
            return value;
        }
    }

    public static class JsonObject {

        public String str;

        @SuppressWarnings("unused")
        public JsonObject() {
        }

        public JsonObject(String str) {
            this.str = str;
        }
    }

    @Test
    public void test() throws Exception {
        String value = System.currentTimeMillis() + "";
        standaloneSetup(new JsonController()).build()
                .perform(post("/")
                        .content(new ObjectMapper().writeValueAsString(new JsonObject(value)))
                        .contentType(MediaType.APPLICATION_JSON))
//                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.str").value(value));
    }
}
