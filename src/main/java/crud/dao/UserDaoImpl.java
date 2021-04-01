//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package crud.dao;

import crud.model.User;
import java.util.List;
import java.util.function.Function;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserDaoImpl implements UserDao {
    @Autowired
    private EntityManagerFactory entityManagerFactory;

    public UserDaoImpl() {
    }

    public void add(User user) {
        this.queryWithTransaction((entityManager) -> {
            entityManager.persist(user);
            return null;
        });
        System.out.println(user.getName() + "huj");
    }

    public User get(long id) {
        return (User)this.queryWithTransaction((entityManager) -> {
            return (User)entityManager.find(User.class, id);
        });
    }

    public User remove(long id) {
        return (User)this.queryWithTransaction((entityManager) -> {
            User user = (User)entityManager.find(User.class, id);
            entityManager.remove(user);
            return user;
        });
    }

    public User update(long id, User user) {
        return (User)this.queryWithTransaction((entityManager) -> {
            entityManager.detach(entityManager.find(User.class, id));
            user.setId(id);
            entityManager.merge(user);
            return user;
        });
    }

    public List<User> getUsers() {
        return (List)this.queryWithTransaction((entityManager) -> {
            return entityManager.createQuery("select user from User user").getResultList();
        });
    }

    private <T> T queryWithTransaction(Function<EntityManager, T> function) {
        T result = null;
        EntityTransaction transaction = null;
        EntityManager entityManager = this.entityManagerFactory.createEntityManager();

        try {
            entityManager.getTransaction().begin();
            result = function.apply(entityManager);
            transaction = entityManager.getTransaction();
            transaction.commit();
        } catch (HibernateException var6) {
            if (transaction != null) {
                transaction.rollback();
            }

            System.err.println(var6.getMessage());
        }

        return result;
    }
}
