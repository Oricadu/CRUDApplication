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
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Query;
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

    public User get(@Param("userId") long id) {
//        return entityManager.find(User.class, id);

        javax.persistence.Query query = entityManager.createQuery("SELECT u FROM User u JOIN FETCH u.roles r WHERE u.id = :userId", User.class);
        query.setParameter("userId", id);
        User user = (User) query.getSingleResult();
        return user;
    }

    @Override
    public User getUserByUsername(@Param("username") String username) {
        javax.persistence.Query query = entityManager.createQuery("SELECT u FROM User u JOIN FETCH u.roles r WHERE u.email = :username", User.class);
        query.setParameter("username", username);
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

//    @Query("SELECT u FROM User u JOIN FETCH u.roles r")
    public List<User> getUsers() {
        return entityManager.createQuery("SELECT u FROM User u JOIN FETCH u.roles r").getResultList();

    }

}
