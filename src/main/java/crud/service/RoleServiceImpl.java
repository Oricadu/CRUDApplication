package crud.service;

import crud.dao.RoleDao;
import crud.dao.UserDao;
import crud.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleDao roleDao;

    public RoleServiceImpl() {
    }

    @Override
    @Transactional
    public List<Role> getListRoles() {
        return roleDao.getListRoles();
    }

    @Override
    @Transactional
    public Role getByName(String name) {
        return roleDao.getByName(name);
    }

    @Transactional
    @Override
    public Role getById(long id) {
        return roleDao.getById(id);
    }
}
