package ws.converter.user;

import common.converter.ReflectionConverter;
import domain.User;
import org.springframework.stereotype.Component;
import ws.model.user.UserSaveRequest;

/**
 * @author Dmitry Tsydzik
 * @since Date: 19.01.14
 */
@Component
public class UserSaveRequestToUserConverter extends ReflectionConverter<UserSaveRequest, User> {
}
