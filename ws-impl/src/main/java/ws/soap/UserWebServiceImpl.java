package ws.soap;

import domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.api.UserService;
import common.converter.Converter;
import ws.api.UserWebService;
import ws.config.WsConstants;
import ws.model.user.UserSaveRequest;
import ws.model.user.UserResponse;

import javax.jws.WebService;
import java.util.List;

/**
 * @author Dmitry Tsydzik
 * @since Date: 23.11.13
 */
@Service
@WebService(
        targetNamespace = WsConstants.USER_SERVICE_NAMESPACE,
        endpointInterface = WsConstants.USER_SERVICE_INTERFACE,
        serviceName = WsConstants.USER_SERVICE_NAME,
        portName = "UserServicePort"
)
public class UserWebServiceImpl implements UserWebService {

    @Autowired
    private UserService userService;

    @Autowired
    private Converter<User, UserResponse> userToUserResponseConverter;

    @Autowired
    private Converter<UserSaveRequest, User> userSaveRequestToUserConverter;

    @Override
    public UserResponse getUser(Long id) {
        return userToUserResponseConverter.convert(userService.get(id));
    }

    @Override
    public UserResponse saveUser(UserSaveRequest userSaveRequest) {
        User user = userSaveRequestToUserConverter.convert(userSaveRequest);
        User saved = userService.save(user);
        return userToUserResponseConverter.convert(saved);
    }

    @Override
    public List<UserResponse> findAllUsers() {
        List<User> users = userService.findAll();
        return userToUserResponseConverter.convertCollection(users);
    }
}
