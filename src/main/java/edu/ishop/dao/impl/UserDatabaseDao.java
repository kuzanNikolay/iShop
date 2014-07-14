package edu.ishop.dao.impl;

import edu.ishop.acessor.DatabaseDatasourceAccessor;
import edu.ishop.dao.UserDao;
import edu.ishop.model.RoleName;
import edu.ishop.model.User;
import edu.ishop.utils.ApplicationConfiguration;

import java.util.List;
import java.util.Set;

public class UserDatabaseDao extends DatabaseDatasourceAccessor implements UserDao{
    @Override
    public User getByUsername(String username) {
        throw new UnsupportedOperationException("getByUsername");
    }

    @Override
    public Set<User> getUsersByUserRoleName(RoleName roleName) {
        throw new UnsupportedOperationException("getUsersByUserRoleName");
    }

    @Override
    public List<User> getAll() {
        throw new UnsupportedOperationException("getAll");
    }

    @Override
    public User getById(long Id) {
        throw new UnsupportedOperationException("getById");
    }

    @Override
    public void save(User item) {
        throw new UnsupportedOperationException("save");
    }

    @Override
    public void delete(User item) {
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
