package repo;

import domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Dmitry Tsydzik
 * @since Date: 13.10.13
 */
public interface UserRepository extends JpaRepository<User, Long> {
}
