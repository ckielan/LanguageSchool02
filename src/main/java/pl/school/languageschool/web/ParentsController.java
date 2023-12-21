package pl.school.languageschool.web;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
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
@RequestMapping("/parents")
public class ParentsController {


    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private final userServiceImpl userService;

    public ParentsController(UserRepository userRepository, RoleRepository roleRepository, userServiceImpl userService) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.userService = userService;
    }

    @GetMapping("/list")
    public String parentsList(Model model){
        Role role;
        role=roleRepository.findByName("ROLE_PARENT");
        model.addAttribute(userRepository.findByRoles(role));
        return ("/parents/parentsList");
    }

    @GetMapping("/add")
    public String parentsAdd(Model model, User user) {
        model.addAttribute("user", new User());
        model.addAttribute("previousRequest", "/parents/add");
        return "/parents/registerParent";

    }

    @PostMapping("/add")
    public String parentsAdd(@Valid User user, BindingResult bindingResult, Model model) {
        Role role;
        role=roleRepository.findByName("ROLE_PARENT");
        if (bindingResult.hasErrors()) {
            model.addAttribute("bindingResult", bindingResult);
            return "/parents/registerParent";
        } else {
            if (user.getId() == null) userService.saveUser(user,role);
            else userService.updateUser(user);
            return "redirect:/home";
        }
    }
}
