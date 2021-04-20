package crud.service;

import crud.dao.RoleDao;
import crud.dao.UserDao;
import crud.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleDao roleDao;

    public RoleServiceImpl() {
    }

    @Override
    public List<Role> getListRoles() {
        return roleDao.getListRoles();
    }

    @Override
    public Role getById(long id) {
        return roleDao.getById(id);
    }

    @Override
    public Role getByName(String name) {
        return roleDao.getByName(name);
    }
}
