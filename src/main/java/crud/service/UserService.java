//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package crud.service;

import crud.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    void add(User var1);

    User get(long var1);

    User getUserByUsername(String username);

    User remove(long var1);

    User update(long var1, User var3);

    List<User> getUsers();

}
