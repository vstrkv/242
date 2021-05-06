package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import web.dao.RoleDao;
import web.dao.UserDao;
import web.model.User;

import java.util.List;
@Service
public class UserServicelmp implements UserService{

    private UserDao userDao;

    private RoleDao roleDao;


    @Autowired
    public UserServicelmp(UserDao userDao) {
        this.userDao = userDao;
    }

    @Autowired
    public UserServicelmp(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    @Override
    public void save(User user) {

    }

    @Override
    public User findByUsername(String username) {
        return null;
    }
}
