package app.controllers;

import java.security.Principal;

import app.Security.CustomUserDetails;
import app.Security.CustomUserDetailsService;
import app.Security.UserService;
import app.Security.dto.RegisterDto;
import app.Security.dto.UserDto;
import app.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequiredArgsConstructor
public class UserController {


    private final CustomUserDetailsService userDetailsService;


    private final UserService userService;


    @GetMapping("/home")
    public String home(Model model, Principal principal) {
        CustomUserDetails userDetails = (CustomUserDetails) userDetailsService.loadUserByUsername(principal.getName());
        model.addAttribute("user", userDetails);
        System.out.println("user :   "+userDetails.getEmail());
        return "home";
    }

    @GetMapping("/admin")
    public String home1(Model model,Principal principal) {
        CustomUserDetails userDetails = (CustomUserDetails) userDetailsService.loadUserByUsername(principal.getName());
        model.addAttribute("user", userDetails);
        System.out.println(userDetails.getEmail());
        return "admin";
    }

    @GetMapping("/market2")
    public String home2() {
        return "home";
    }

    @GetMapping("/error2")
    public String error() {
        return "error404";
    }

    @GetMapping("/login")
    public String login(Model model, UserDto userDto) {
        model.addAttribute("user", userDto);
        return "login";
    }

    @GetMapping("/register")
    public String register(Model model, RegisterDto registerDto) {
        model.addAttribute("user", registerDto);
        return "register";
    }

    @PostMapping("/register")
    public String registerSava(@ModelAttribute("user") RegisterDto userDto, Model model , RedirectAttributes redirectAttributes) {
        User user = userService.findByEmail(userDto.getEmail());
        if (user != null) {
            model.addAttribute("Userexist", user);
            return "register";
        }
        user =new User(userDto.getFirstname(),userDto.getLasttname(),userDto.getEmail(), userDto.getPw());
        userService.save(user);
        redirectAttributes.addFlashAttribute("success","kiiiiiiii");
        return "redirect:/login";
    }
}