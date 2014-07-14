package edu.ishop.dao;

import edu.ishop.model.RoleName;
import edu.ishop.model.User;

import java.util.Set;

/**
 * Created by Nikolay on 14.07.14.
 */
public interface UserDao extends ItemDao<User> {
    User getByUsername(String username);
    Set<User> getUsersByUserRoleName(RoleName roleName);
}
