package pl.school.languageschool.web;

import jakarta.validation.Valid;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.school.languageschool.domain.User;
import pl.school.languageschool.repository.UserRepository;
import pl.school.languageschool.service.UserService;
import pl.school.languageschool.service.userServiceImpl;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserRepository userRepository;
    private final userServiceImpl userService;

    public UserController(UserRepository userRepository, userServiceImpl userService) {
        this.userRepository = userRepository;
        this.userService = userService;
    }

    @GetMapping("/add")
    public String students(Model model, User user) {
        model.addAttribute("user", new User());
        return "/user/createAccount";

    }
    @PostMapping("/add")
    public String students(@Valid User user, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()) {
            model.addAttribute("bindingResult", bindingResult);
            return "/createAccount";
        } else {
            if (user.getId() == null) userService.saveUser(user);
            else userService.updateUser(user);
            return "redirect:/home";
        }
    }

    @GetMapping("/create-admin")
    @ResponseBody
    public String createAdmin() {
        User user = new User();
        user.setUsername("admin");
        user.setPassword("admin");
        userService.saveAdmin(user);
        return "Utworzono administratora ";
    }

//    @GetMapping("/create-account")
//    public String createUser(Model model) {
//        model.addAttribute("user", new User());
//        return "/createAccount";
//    }
//
//    @PostMapping("/create-account")
//    public String createUser(@Valid User user, BindingResult bindingResult, Model model) {
//        if (bindingResult.hasErrors()) {
//            model.addAttribute("bindingResult", bindingResult);
//            return "/createAccount";
//        } else {
//            if (user.getId() == null) userService.saveUser(user);
//            else userService.updateUser(user);
//            return "redirect:/home";
//        }
//    }

    @GetMapping("/update")
    public String updateUser(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("user", userService.findByUserName(authentication.getName()));
        return ("/user/updateAccount");
    }

        @PostMapping("/update")
    public String updateUser(@Valid User user, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("bindingResult", bindingResult);
            return "/user/updateAccount";
        } else {

            userRepository.save(user);
            return "redirect:/home";
        }


    }

}

