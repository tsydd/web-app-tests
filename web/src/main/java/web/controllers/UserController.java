package web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ws.api.UserWebService;
import ws.model.user.UserResponse;
import ws.model.user.UserSaveRequest;

import java.util.List;

/**
 * @author Dmitry Tsydzik
 * @since Date: 16.10.13
 */
@Controller
@RequestMapping("users")
public class UserController {

    @Autowired
    private UserWebService userWebService;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<UserResponse> list() {
        return userWebService.findAllUsers();
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public UserResponse save(@RequestBody UserSaveRequest user) {
        return userWebService.saveUser(user);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public UserResponse get(@PathVariable Long id) {
        return userWebService.getUser(id);
    }
}
