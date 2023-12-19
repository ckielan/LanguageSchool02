package pl.school.languageschool.web;


import  org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.school.languageschool.domain.Role;
import pl.school.languageschool.repository.RoleRepository;
import pl.school.languageschool.repository.UserRepository;

@Controller
@RequestMapping("/teacher")
public class TeachersController {


    private UserRepository userRepository;
    private RoleRepository roleRepository;

    public TeachersController(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @GetMapping("/list")
    public String studentsList(Model model){
        Role role;
        role=roleRepository.findByName("ROLE_TEACHER");
        model.addAttribute(userRepository.findByRoles(role));
        return ("/teachers/teachersList");
    }

//    @ModelAttribute("users")
//    public List<User> students(Model model){
//
//
//    }
}
