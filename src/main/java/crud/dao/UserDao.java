//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package crud.dao;

import crud.model.User;
import java.util.List;

public interface UserDao {
    void add(User var1);

    User get(long var1);

    User remove(long var1);

    User update(long var1, User var3);

    List<User> getUsers();
}