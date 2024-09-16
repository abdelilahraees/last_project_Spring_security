package app.Security;


import app.Security.dto.UserDto;
import app.modul.User;

public interface UserService {
    User findByUsername(String username);
    User findByFullname(String fullname);

    User save(UserDto userDto);

}