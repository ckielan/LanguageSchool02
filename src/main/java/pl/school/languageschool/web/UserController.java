package pl.school.languageschool.web;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.school.languageschool.domain.User;
import pl.school.languageschool.service.userServiceImpl;

@Controller
public class UserController {

    private final userServiceImpl userService;

    public UserController(userServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String students(Model model, User user) {
        model.addAttribute("user", userService.findAllUser());
        return "/users";

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

    @GetMapping("/create-account")
    public String createUser(Model model) {
        model.addAttribute("user", new User());
        return "/user/createAccount";
    }

    @PostMapping("/create-account")
    public String createUser(@Valid User user, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("bindingResult", bindingResult);
            return "/user/createAccount";
        } else {
            if(user.getId()==null)userService.saveUser(user);
            else userService.updateUser(user);
            return "redirect:/home";
        }


    }


}
