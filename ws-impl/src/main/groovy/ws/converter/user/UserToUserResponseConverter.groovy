package ws.converter.user

import domain.User
import org.springframework.stereotype.Component
import common.converter.AbstractConverter
import ws.model.user.UserResponse

/**
 * @author Dmitry Tsydzik
 * @since Date: 23.11.13
 */
@Component
class UserToUserResponseConverter extends AbstractConverter<User, UserResponse> {
    @Override
    UserResponse convert(User user) {
        UserResponse userResponse = new UserResponse()
        userResponse.id = user.id
        userResponse.email = user.email
        userResponse.password = user.password
        userResponse
    }
}
