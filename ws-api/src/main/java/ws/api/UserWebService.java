package ws.api;

import ws.config.WsConstants;
import ws.model.user.UserSaveRequest;
import ws.model.user.UserResponse;

import javax.jws.WebService;
import java.util.List;

/**
 * @author Dmitry Tsydzik
 * @since Date: 23.11.13.
 */
@WebService(
        name = "UserServiceInterface",
        targetNamespace = WsConstants.USER_SERVICE_NAMESPACE
)
public interface UserWebService {

    UserResponse getUser(Long id);

    UserResponse saveUser(UserSaveRequest userSaveRequest);

    List<UserResponse> findAllUsers();
}
