package service.api;

import domain.User;

import java.util.List;

/**
 * @author Dmitry Tsydzik
 * @since Date: 13.10.13
 */
public interface UserService {

    User save(User user);

    User get(Long id);

    List<User> findAll();
}
