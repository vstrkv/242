package web.dao;

import web.models.Role;

import java.util.List;

public interface RoleDao {
    void add(Role role);
    void delete(Long id);
    void update(Role role);
    List<Role> getAllRoles();
    Role getRoleById(Long id);
    Role getRoleByName(String name);
}
