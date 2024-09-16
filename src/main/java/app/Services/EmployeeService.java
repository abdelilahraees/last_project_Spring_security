package app.Services;

import app.Repository.UserRepo;
import app.modul.Employee;
import app.modul.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;



@Service
public class EmployeeService {


    private User user;
    private List<User> userList = new ArrayList();


    @Autowired
    private    UserRepo userRepo;



public  List<User> all(){


    return userRepo.findAll();
}
}
