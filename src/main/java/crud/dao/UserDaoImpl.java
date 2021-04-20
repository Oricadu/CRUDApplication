//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package crud.dao;

import crud.model.User;

import java.util.List;
import java.util.function.Function;
import javax.persistence.*;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {
    @PersistenceContext(unitName = "entityManagerFactory")
    @Autowired
    private EntityManager entityManager;

    public UserDaoImpl() {
    }

    public void add(User user) {
        entityManager.persist(user);
    }

    public User get(long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public User getUserByUsername(String username) {
        Query query = entityManager.createQuery("select user from User user where user.email = :email", User.class);
        query.setParameter("email", username);
        User user = (User) query.getSingleResult();
        return user;
    }

    public User remove(long id) {
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
        return user;
    }

    public User update(long id, User user) {
        entityManager.merge(user);
        return user;
    }

    public List<User> getUsers() {
        return entityManager.createQuery("select user from User user").getResultList();

    }

}
