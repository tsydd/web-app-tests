package service.converter.assembler

import domain.User
import org.springframework.stereotype.Component
import service.converter.AbstractConverter
import service.dto.UserDto

/**
 * @author Dmitry Tsydzik
 * @since Date: 13.10.13
 */
@Component
class UserAssembler extends AbstractConverter<UserDto, User> {

    User convert(UserDto from) {
        User to = new User()
        to.id = from.id
        to.email = from.email
        to.password = from.password
        to
    }
}
