package edu.java.ishop.dao;

import edu.java.ishop.model.RoleName;
import edu.java.ishop.model.User;

import java.util.Set;

/**
 * Created by Nikolay on 14.07.14.
 */
public interface UserDao extends ItemDao<User> {
    User getByUsername(String username);
    Set<User> getUsersByUserRoleName(RoleName roleName);
}
