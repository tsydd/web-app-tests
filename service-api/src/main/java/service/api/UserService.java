package service.api;

import service.dto.UserDto;

import java.util.List;

/**
 * @author Dmitry Tsydzik
 * @since Date: 13.10.13
 */
public interface UserService {

    UserDto save(UserDto user);

    List<UserDto> findAll();
}
