package edu.ishop.dao;

import edu.ishop.model.RoleName;
import edu.ishop.model.UserRole;

/**
 * Created by Nikolay on 14.07.14.
 */
public interface UserRoleDao extends ItemDao<UserRole> {
    UserRole getByRoleName(RoleName roleName);
}
