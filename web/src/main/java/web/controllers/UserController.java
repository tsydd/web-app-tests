package web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<UserDto> list() {
        return userService.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public UserDto save(@RequestBody UserDto user) {
        return userService.save(user);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public UserDto get(@PathVariable Long id) {
        return userService.get(id);
    }
}
