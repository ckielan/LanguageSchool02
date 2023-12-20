package pl.school.languageschool.web;

import jakarta.validation.Valid;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.school.languageschool.domain.Role;
import pl.school.languageschool.domain.User;
import pl.school.languageschool.repository.RoleRepository;
import pl.school.languageschool.repository.UserRepository;
import pl.school.languageschool.service.UserService;
import pl.school.languageschool.service.userServiceImpl;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserRepository userRepository;
    private final userServiceImpl userService;
    private final RoleRepository roleRepository;

    public UserController(UserRepository userRepository, userServiceImpl userService, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.userService = userService;
        this.roleRepository = roleRepository;
    }



    @GetMapping("/add")
    public String students(Model model, User user) {
        model.addAttribute("user", new User());
        model.addAttribute("previousRequest", "/users/add");
        return "/user/createAccount";

    }

    @PostMapping("/add")
    public String students(@Valid User user, BindingResult bindingResult, Model model) {
        Role role;
        role=roleRepository.findByName("ROLE_STUDENT");
        if (bindingResult.hasErrors()) {
            model.addAttribute("bindingResult", bindingResult);
            return "/createAccount";
        } else {
            if (user.getId() == null) userService.saveUser(user,role);
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
            User changedUser = userRepository.findByUsername(user.getUsername());
            changedUser.setEmail(user.getEmail());
            changedUser.setFirstname(user.getFirstname());
            changedUser.setLastname(user.getLastname());
            userRepository.save(changedUser);
            return "redirect:/home";
        }
    }

    @GetMapping("/list")
    public String userList(Model model) {
        model.addAttribute("users", userRepository.findAll());
        return ("/admin/users");
    }

    @ModelAttribute("users")
    public List<User> users(){return userRepository.findAll();}
}

