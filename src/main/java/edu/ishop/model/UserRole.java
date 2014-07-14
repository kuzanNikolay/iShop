package edu.ishop.model;

import java.util.Set;

/**
 * Created by Nikolay on 14.07.14.
 */
public class UserRole extends Model {

    private Set<User> users;
    private RoleName roleName;

    public UserRole(long id) {
        super(id);
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public RoleName getRoleName() {
        return roleName;
    }

    public void setRoleName(RoleName roleName) {
        this.roleName = roleName;
    }
}
