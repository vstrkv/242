package web.service;

import web.dao.RoleDao;
import web.dao.UserDao;
import web.models.Role;
import web.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp implements UserService{

    @Autowired
    private UserDao userDao;
    @Autowired
    private RoleDao roleDao;

    @Override
    public void add(User user) {
        userDao.add(user);
    }

    @Override
    public void delete(Long id) {
        userDao.delete(id);
    }

    @Override
    public void update(User user) {
        userDao.update(user);
    }

    @Override
    public User getUserById(Long id) {
        return userDao.getUser(id);
    }

    @Override
    public User getUserByName(String name) {
        return userDao.getUserByName(name);
    }

    @Override
    public List<Role> roleUser() {
        return roleDao.getAllRoles();
    }

    @Override
    public List<User> listUser() {
        return userDao.getAllUser();
    }

    @Override
    public User getUser(Long id) {
        return userDao.getUser(id);
    }
}
