package web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import web.dto.LoginRequestDto;

/**
 * @author Dmitry Tsydzik
 * @since Date: 04.10.13
 */
@Controller
public class LoginController {

    @RequestMapping("login")
    @ResponseBody
    public LoginRequestDto doLogin(@RequestBody LoginRequestDto login) {
        return login;
    }

}
