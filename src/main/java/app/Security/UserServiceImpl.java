package app.Security;

import app.Security.Repository.UserRepository;
import app.Security.UserService;
import app.Security.dto.UserDto;
import app.modul.User;
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
        return userRepository.findByUsernameOrFullname(username,username);
    }

    @Override
    public User findByFullname(String fullname) {
        return userRepository.findByUsernameOrFullname(fullname,fullname);
    }

    @Override
    public User save(UserDto userDto) {
        User user = new User(userDto.getUsername(), passwordEncoder.encode(userDto.getPassword()),
                userDto.getFullname());
        return userRepository.save(user);
    }




}