package app.Security;

import app.Security.Repository.UserRepository;
import app.Security.dto.UserDto;
import app.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    PasswordEncoder passwordEncoder;

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        super();
        this.userRepository = userRepository;
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsernameOrEmail(username, username);
    }

    @Override
    public User findByFullname(String fullname) {
        return userRepository.findByUsernameOrEmail(fullname, fullname);
    }

    @Override
    public User save(User userDto) {
        User user = new User(userDto.getUsername(), userDto.getFullname(), userDto.getEmail(), passwordEncoder.encode(userDto.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }


}