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
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;

    public UserServiceImpl() {
    }
    @Override
    @Transactional
    public void add(User user) {
        this.userDao.add(user);
    }

    @Override
    @Transactional
    public User get(long id) {
        return this.userDao.get(id);
    }

    @Override
    @Transactional
    public User remove(long id) {
        return this.userDao.remove(id);
    }

    @Override
    @Transactional
    public User update(long id, User user) {
        return this.userDao.update(id, user);
    }

    @Override
    @Transactional
    public List<User> getUsers() {
        return this.userDao.getUsers();
    }
}
