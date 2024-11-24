package app.Security.Repository;

import app.Security.dto.UserDto;
import app.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsernameOrEmail(String username, String fullename);

    User save(User userDto);

    User findByEmail(String email);
}