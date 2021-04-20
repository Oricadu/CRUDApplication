package crud.dao;

import crud.model.Role;

import java.util.List;

public interface RoleDao {
    public List<Role> getListRoles();
    public Role getById(long id);
    public Role getByName(String name);
}
