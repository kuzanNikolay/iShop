package edu.java.ishop.acessor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.postgresql.ds.PGPoolingDataSource;

public abstract class DatabaseDatasourceAccessor {

	private final InitialContext initialContext;
	public DatabaseDatasourceAccessor() {
		try {
			initialContext = new InitialContext();
		} catch (NamingException e) {
			// TODO log
			throw new RuntimeException(e);
		}
	}

	public Connection openAccessWithDriverManager() throws SQLException {
		return DriverManager.getConnection(getConnectionUrl(), getUsername(),
				getPassword());
	}

	public Connection openAccessWithDatasource() throws SQLException {

		PGPoolingDataSource datasource = new PGPoolingDataSource();
		datasource.setServerName(getHost());
		datasource.setPortNumber(getPort());
		datasource.setDatabaseName(getDatabaseName());
		datasource.setUser(getUsername());
		datasource.setPassword(getPassword());
		datasource.setMaxConnections(getMaxConnections());
		datasource.setInitialConnections(20);
	/*
		DataSource ds;
		try {
			ds = (DataSource)initialContext.lookup("java:/comp/env/jdbc/postgres");
			return ds.getConnection();
		} catch (NamingException | SQLException e) {
			throw new RuntimeException(e);
		}
	*/
		return datasource.getConnection();
	}

	public abstract String getHost();

	public abstract int getPort();
	
	public abstract String getDatabaseName();

	public abstract String getPassword();

	public abstract String getUsername();

	public abstract String getConnectionUrl();

	public abstract int getMaxConnections();

}
