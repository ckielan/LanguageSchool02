package pl.school.languageschool.service;

import pl.school.languageschool.domain.Role;
import pl.school.languageschool.domain.User;

public interface UserService {
    User findByUserName(String name);
    void saveUser(User user, Role role);
    void updateUser(User user);
}
