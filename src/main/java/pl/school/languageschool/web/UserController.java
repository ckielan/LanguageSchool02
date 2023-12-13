package pl.school.languageschool.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.school.languageschool.domain.Users;
import pl.school.languageschool.service.userService;

@Controller
public class UserController {

    private final userService userService;

    public UserController(pl.school.languageschool.service.userService userService) {
        this.userService = userService;
    }

    @GetMapping("/students")
    public String students (Model model, Users users)
    {
        model.addAttribute("users",userService.findAllUser());
        return "/students";

    }
}
