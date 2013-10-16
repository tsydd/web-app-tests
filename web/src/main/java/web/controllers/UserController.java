package web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.api.UserService;
import service.dto.UserDto;

import java.util.List;

/**
 * @author Dmitry Tsydzik
 * @since Date: 16.10.13
 */
@Controller
@RequestMapping("users")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping
    @ResponseBody
    public List<UserDto> userList() {
        return userService.findAll();
    }
}
