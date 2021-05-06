package web.service;

import web.models.Role;
import web.models.User;

import java.util.List;

public interface UserService {
    void add(User user);
    void delete(Long id);
    void update(User user);
    List<User> listUser();
    List<Role> roleUser();
    User getUserById(Long id);
    User getUserByName(String name);
    User getUser(Long id);
}
