package web.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import web.model.User;

public interface RoleDao extends JpaRepository<User, Integer> {
}
