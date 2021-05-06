package web.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.models.Role;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@Transactional
public class RoleDaoImp implements RoleDao{

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void add(Role role) {
        entityManager.persist(role);
    }

    @Override
    public void delete(Long id) {
        entityManager.remove(getRoleById(id));
    }

    @Override
    public void update(Role role) {
        entityManager.merge(role);
    }

    @Override
    public List<Role> getAllRoles() {
        return entityManager.createQuery("SELECT r from Role r").getResultList();
    }

    @Transactional(readOnly = true)
    @Override
    public Role getRoleById(Long id) {
        TypedQuery<Role> query = entityManager.createQuery("select r from Role r where r.id=:id", Role.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Transactional(readOnly = true)
    @Override
    public Role getRoleByName(String name) {
        TypedQuery<Role> query = entityManager.createQuery("select r from Role r where r.role=:name", Role.class);
        query.setParameter("name", name);
        return query.getSingleResult();
    }
}
