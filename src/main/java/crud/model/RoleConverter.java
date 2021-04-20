package crud.model;

import crud.dao.RoleDao;
import crud.dao.RoleDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class RoleConverter implements Converter<String, Role> {
    @Autowired
    RoleDao roleDao;

    @Override
    public Role convert(String id) {
        System.out.println("converter " + roleDao + " id " + id);
        Role role = null;
        long intId = Integer.parseInt(id);
        System.out.println(intId);
        if (roleDao != null) {
            role = roleDao.getById(intId);
        }
        System.out.println("role " + role);
        return role;
    }
}
