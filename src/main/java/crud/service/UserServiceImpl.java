//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package crud.service;

import crud.dao.UserDao;
import crud.model.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;

    public UserServiceImpl() {
    }

    public void add(User user) {
        this.userDao.add(user);
    }

    public User get(long id) {
        return this.userDao.get(id);
    }

    public User remove(long id) {
        return this.userDao.remove(id);
    }

    public User update(long id, User user) {
        return this.userDao.update(id, user);
    }

    public List<User> getUsers() {
        return this.userDao.getUsers();
    }
}
