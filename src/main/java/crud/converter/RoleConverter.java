package crud.converter;

import crud.dao.RoleDao;
import crud.dao.RoleDaoImpl;
import crud.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class RoleConverter implements Converter<String, Role> {

    @Autowired
    private RoleDao roleDao;

    @Override
    public Role convert(String id) {
        Role role = null;
        if (roleDao != null) {
            role = roleDao.getById(Integer.parseInt(id));
        }
        return role;
    }
}
