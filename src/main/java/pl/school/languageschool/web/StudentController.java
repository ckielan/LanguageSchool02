package pl.school.languageschool.web;

import org.eclipse.tags.shaded.org.apache.xpath.operations.Mod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.school.languageschool.domain.Role;
import pl.school.languageschool.domain.User;
import pl.school.languageschool.repository.RoleRepository;
import pl.school.languageschool.repository.UserRepository;

import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {


    private UserRepository userRepository;
    private RoleRepository roleRepository;

    public StudentController(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @GetMapping("/list")
    public String studentsList(Model model){
        Role role;
        role=roleRepository.findByName("ROLE_STUDENT");
        model.addAttribute(userRepository.findByRoles(role));
        return ("/students/studentsList");
    }

//    @ModelAttribute("users")
//    public List<User> students(Model model){
//
//
//    }
}
