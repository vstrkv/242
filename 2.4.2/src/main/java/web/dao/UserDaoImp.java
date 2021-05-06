package web.dao;

import org.springframework.beans.factory.annotation.Autowired;
import web.models.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@Transactional
public class UserDaoImp implements UserDao{

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void add(User user) {
        entityManager.persist(user);
    }

    @Override
    public void delete(Long id) {
        entityManager.remove(getUser(id));
    }

    @Override
    public void update(User user) {
        entityManager.merge(user);
    }

    @Override
    public User getUser(Long id) {
        return entityManager.find(User.class, id);
    }

    @Transactional(readOnly = true)
    @Override
    public User getUserByName(String name) {
        TypedQuery<User> query = entityManager.createQuery("select u from User u where u.name = :name", User.class)
                .setParameter("name",name);
        return query.getSingleResult();
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> getAllUser() {
        return entityManager.createQuery("Select u from User u").getResultList();
    }
}
