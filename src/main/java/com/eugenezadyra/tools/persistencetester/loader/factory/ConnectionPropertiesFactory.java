package com.eugenezadyra.tools.persistencetester.loader.factory;

import com.eugenezadyra.tools.persistencetester.loader.factory.parser.ConnectionUrlParser;
import com.eugenezadyra.tools.persistencetester.loader.vo.ConnectionPropertiesVO;

import java.util.Properties;

/**
 * @author eugene zadyra
 */
public class ConnectionPropertiesFactory {

	private final static String CONNECTION_URL_PROPERTY = "connection.url";
	private final static String USERNAME_PROPERTY = "connection.username";
	private final static String PASSWORD_PROPERTY = "connection.password";

	public ConnectionPropertiesVO createConnectionPropertiesVO(Properties properties) {
		ConnectionPropertiesVO vo = new ConnectionPropertiesVO();
		ConnectionUrlParser cup = new ConnectionUrlParser(properties.getProperty(CONNECTION_URL_PROPERTY));
		vo.setConnectionUrl(cup.extractUrl());
		vo.setDbName(cup.extractDbName());
		vo.setPort(cup.extractPort());
		vo.setDbEngine(cup.extractEngine());
		vo.setPassword(properties.getProperty(PASSWORD_PROPERTY));
		vo.setUser(properties.getProperty(USERNAME_PROPERTY));
		return vo;
	}
}
