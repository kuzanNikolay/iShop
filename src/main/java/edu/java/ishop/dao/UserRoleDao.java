package edu.java.ishop.dao;

import edu.java.ishop.model.RoleName;
import edu.java.ishop.model.UserRole;

/**
 * Created by Nikolay on 14.07.14.
 */
public interface UserRoleDao extends ItemDao<UserRole> {
    UserRole getByRoleName(RoleName roleName);
}
