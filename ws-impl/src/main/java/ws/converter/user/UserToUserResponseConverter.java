package ws.converter.user;

import common.converter.ReflectionConverter;
import domain.User;
import org.springframework.stereotype.Component;
import ws.model.user.UserResponse;

/**
 * @author Dmitry Tsydzik
 * @since Date: 19.01.14
 */
@Component
public class UserToUserResponseConverter extends ReflectionConverter<User, UserResponse> {
}
