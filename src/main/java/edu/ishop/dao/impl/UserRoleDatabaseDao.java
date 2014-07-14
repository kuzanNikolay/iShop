package edu.ishop.dao.impl;

import edu.ishop.acessor.DatabaseDatasourceAccessor;
import edu.ishop.dao.UserRoleDao;
import edu.ishop.model.RoleName;
import edu.ishop.model.UserRole;
import edu.ishop.utils.ApplicationConfiguration;

import java.util.List;

/**
 * Created by Nikolay on 14.07.14.
 */
public class UserRoleDatabaseDao extends DatabaseDatasourceAccessor implements UserRoleDao {
    @Override
    public UserRole getByRoleName(RoleName roleName) {
        throw new UnsupportedOperationException("getByRoleName");
    }

    @Override
    public List<UserRole> getAll() {
        throw new UnsupportedOperationException("getAll");
    }

    @Override
    public UserRole getById(long Id) {
        throw new UnsupportedOperationException("getId");
    }

    @Override
    public void save(UserRole item) {
        throw new UnsupportedOperationException("save");
    }

    @Override
    public void delete(UserRole item) {
        throw new UnsupportedOperationException("delete");
    }


    //------------------ Services methods ---------------------------//

    @Override
    public String getPassword() {
        return ApplicationConfiguration.getItem("database.user.password");
    }

    @Override
    public String getUsername() {
        return ApplicationConfiguration.getItem("database.user.name");
    }

    @Override
    public String getConnectionUrl() {
        return ApplicationConfiguration.getItem("database.connection.url");
    }

    @Override
    public String getHost() {
        return ApplicationConfiguration.getItem("database.host");
    }

    @Override
    public String getDatabaseName() {
        return ApplicationConfiguration.getItem("database.name");
    }

    @Override
    public int getMaxConnections() {
        return Integer.parseInt(ApplicationConfiguration
                .getItem("database.max.connections"));
    }

    @Override
    public int getPort() {
        return Integer.parseInt(ApplicationConfiguration
                .getItem("database.port"));
    }
    //-------------------------------------------------------------------//



}
