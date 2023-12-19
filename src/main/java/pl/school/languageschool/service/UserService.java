package pl.school.languageschool.service;

import pl.school.languageschool.domain.User;

public interface UserService {
    User findByUserName(String name);
    void saveUser(User user);
    void updateUser(User user);
}
