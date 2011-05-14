package com.eugenezadyra.tools.persistencetester.loader.vo;

/**
 * @author eugene zadyra
 */
public class ConnectionPropertiesVO {
	private String connectionUrl;
	private String port;
	private String user;
	private String password;
	private String dbName;
	private String dbEngine;

	public String getDbEngine() {
		return dbEngine;
	}

	public void setDbEngine(String dbEngine) {
		this.dbEngine = dbEngine;
	}

	public String getHost() {
		return connectionUrl;
	}

	public void setConnectionUrl(String connectionUrl) {
		this.connectionUrl = connectionUrl;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDbName() {
		return dbName;
	}

	public void setDbName(String dbName) {
		this.dbName = dbName;
	}
}
