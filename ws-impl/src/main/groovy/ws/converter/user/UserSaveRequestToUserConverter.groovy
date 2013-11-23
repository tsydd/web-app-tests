package ws.converter.user

import domain.User
import org.springframework.stereotype.Component
import common.converter.AbstractConverter
import ws.model.user.UserSaveRequest

/**
 * @author Dmitry Tsydzik
 * @since Date: 23.11.13
 */
@Component
class UserSaveRequestToUserConverter extends AbstractConverter<UserSaveRequest, User> {
    @Override
    User convert(UserSaveRequest userSaveRequest) {
        User user = new User()
        user.id = userSaveRequest.id
        user.email = userSaveRequest.email
        user.password = userSaveRequest.password
        user
    }
}
