package crud.service;

import crud.model.Role;

import java.util.List;

public interface RoleService {
    public List<Role> getListRoles();
    public Role getById(long id);
    public Role getByName(String name);
}
