package com.eugenezadyra.tools.persistencetester.loader.factory.parser;

import com.eugenezadyra.tools.persistencetester.util.StringUtil;

/**
 * Extract info from strings like jdbc:mysql://localhost:3306/dbname
 *
 * @author eugene zadyra
 */
public class ConnectionUrlParser {
	private String connectionUrl;

	public ConnectionUrlParser(String connectionUrl) {
		this.connectionUrl = connectionUrl;
	}

	public String extractPort() {
		return StringUtil.substringByRegexp(connectionUrl, ":(\\d+)/");
	}

	public String extractUrl() {
		return StringUtil.substringBetween(connectionUrl, "://", ":");
	}

	public String extractEngine() {
		return StringUtil.substringBefore(connectionUrl, "://");
	}

	public String extractDbName() {
		return StringUtil.substringAfterLast(connectionUrl, "/");
	}
}
