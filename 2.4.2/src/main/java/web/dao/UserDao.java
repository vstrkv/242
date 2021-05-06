package web.dao;

import web.models.User;

import java.util.List;

public interface UserDao {
    void add(User user);
    void delete(Long id);
    void update(User user);
    User getUser(Long id);
    User getUserByName(String name);
    List<User> getAllUser();
}
