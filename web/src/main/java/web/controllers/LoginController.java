package web.controllers;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import web.dto.LoginRequestDto;

/**
 * @author Dmitry Tsydzik
 * @since Date: 04.10.13
 */
@RestController
public class LoginController {

    @RequestMapping("login")
    public LoginRequestDto doLogin(@RequestBody LoginRequestDto login) {
        return login;
    }

}
