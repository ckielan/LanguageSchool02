package pl.school.languageschool.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.school.languageschool.domain.Role;
import pl.school.languageschool.repository.RoleRepository;
import pl.school.languageschool.repository.UserRepository;


@Controller
@RequestMapping("/parents")
public class ParentsController {


    private UserRepository userRepository;
    private RoleRepository roleRepository;

    public ParentsController(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @GetMapping("/list")
    public String studentsList(Model model){
        Role role;
        role=roleRepository.findByName("ROLE_PARENT");
        model.addAttribute(userRepository.findByRoles(role));
        return ("/parents/parentsList");
    }

//    @ModelAttribute("users")
//    public List<User> students(Model model){
//
//
//    }
}
