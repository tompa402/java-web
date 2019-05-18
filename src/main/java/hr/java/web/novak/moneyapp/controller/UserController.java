package hr.java.web.novak.moneyapp.controller;

import hr.java.web.novak.moneyapp.model.User;
import hr.java.web.novak.moneyapp.repository.UserRepository;
import hr.java.web.novak.moneyapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String registerForm(Model model){
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String processForm(Model model, @Validated User user, Errors errors){
        if(errors.hasErrors()){
            model.addAttribute("user", new User());
            return "register";
        }
        userService.save(user);
        return "redirect:/login/";
    }
}
