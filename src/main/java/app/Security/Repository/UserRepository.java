package app.Security.Repository;

import app.Security.dto.UserDto;
import app.modul.User;
import org.springframework.data.jpa.repository.JpaRepository;



public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsernameOrFullname(String username,String fullename);

    User save(UserDto userDto);
}