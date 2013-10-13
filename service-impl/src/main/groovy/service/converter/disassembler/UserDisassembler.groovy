package service.converter.disassembler

import domain.User
import org.springframework.stereotype.Component
import service.converter.AbstractConverter
import service.dto.UserDto

/**
 * @author Dmitry Tsydzik
 * @since Date: 13.10.13
 */
@Component
class UserDisassembler extends AbstractConverter<User, UserDto> {

    @Override
    UserDto convert(User from) {
        UserDto to = new UserDto()
        to.id = from.id
        to.email = from.email
        to.password = from.password
        to
    }
}
