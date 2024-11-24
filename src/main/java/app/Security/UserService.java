package app.Security;


import app.Security.dto.UserDto;
import app.model.User;

public interface UserService {
    User findByUsername(String username);
    User findByFullname(String fullname);
    User save(User user);
    User findByEmail(String email);

}