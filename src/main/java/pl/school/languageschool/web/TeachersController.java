package pl.school.languageschool.web;


import jakarta.validation.Valid;
import  org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.school.languageschool.domain.Role;
import pl.school.languageschool.domain.User;
import pl.school.languageschool.repository.RoleRepository;
import pl.school.languageschool.repository.UserRepository;
import pl.school.languageschool.service.userServiceImpl;

@Controller
@RequestMapping("/teacher")
public class TeachersController {



    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private final userServiceImpl userService;

    public TeachersController(UserRepository userRepository, RoleRepository roleRepository, userServiceImpl userService) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.userService = userService;
    }

    @GetMapping("/list")
    public String teacherList(Model model){
        Role role;
        role=roleRepository.findByName("ROLE_TEACHER");
        model.addAttribute(userRepository.findByRoles(role));
        return ("/teachers/teachersList");
    }
    @GetMapping("/add")
    public String teachers(Model model, User user) {
        model.addAttribute("user", new User());
        model.addAttribute("previousRequest", "/teacher/add");
        return "/teachers/registerTeacher";

    }

    @PostMapping("/add")
    public String teachers(@Valid User user, BindingResult bindingResult, Model model) {
        Role role;
        role=roleRepository.findByName("ROLE_TEACHER");
        if (bindingResult.hasErrors()) {
            model.addAttribute("bindingResult", bindingResult);
            return "/teachers/registerTeacher";
        } else {
            if (user.getId() == null) userService.saveUser(user,role);
            else userService.updateUser(user);
            return "redirect:/home";
        }
    }

}
