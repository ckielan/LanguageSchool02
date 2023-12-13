package pl.school.languageschool.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.school.languageschool.domain.User;
import pl.school.languageschool.service.UserService;
import pl.school.languageschool.service.userServiceImpl;

import java.util.HashSet;

@Controller
public class UserController {

    private final userServiceImpl userService;

    public UserController(userServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping("/students")
    public String students (Model model, User user)
    {
        model.addAttribute("user",userService.findAllUser());
        return "/students";

    }

    @GetMapping("/create-user")
    @ResponseBody
    public String createUser() {
        User user = new User();
        user.setUsername("admin");
        user.setPassword("admin");
        userService.saveUser(user);
        return "admin";
    }
}
