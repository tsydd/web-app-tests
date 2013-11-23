package ws.converter.user

import common.converter.ReflectionConverter
import domain.User
import org.springframework.stereotype.Component
import ws.model.user.UserResponse

/**
 * @author Dmitry Tsydzik
 * @since Date: 23.11.13
 */
@Component
class UserToUserResponseConverter extends ReflectionConverter<User, UserResponse> {
}
