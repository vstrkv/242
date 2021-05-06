package web.service;

import org.springframework.data.jpa.repository.JpaRepository;
import web.model.User;

import java.util.List;

public interface UserService {

    void save(User user);
    User  findByUsername(String username);
}

