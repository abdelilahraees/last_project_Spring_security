//package app.controllers;
//
//
//import app.Security.dto.Register;
//import app.Services.EmployeeService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.MediaType;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//
//@Controller
//@RequestMapping("/")
//public class EmployeeController {
//    @Autowired
//    UserAppRepo userAppRepo;
//
//
//    private final EmployeeService employeeService;
//
//    public EmployeeController(EmployeeService employeeService) {
//        this.employeeService = employeeService;
//    }
//
//
//
//
//
//    @GetMapping("register")
//    public String register(Model model){
//        model.addAttribute("register",new Register());
//        return "register";
//    }
//
//    @GetMapping("employees")
//    public String getAll(Model model) {
//
//
//        model.addAttribute("Employees", employeeService.all());
//        return "user";
//    }
//
//    @GetMapping("login")
//    public String login(Model model) {
//
//
//       model.addAttribute("login",new LoginModul());
//        return "login";
//    }
//
//
//}
