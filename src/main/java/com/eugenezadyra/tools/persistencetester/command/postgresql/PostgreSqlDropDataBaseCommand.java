package com.eugenezadyra.tools.persistencetester.command.postgresql;

import com.eugenezadyra.tools.persistencetester.command.AbstractCommand;
import com.eugenezadyra.tools.persistencetester.loader.vo.ConnectionPropertiesVO;

/**
 * @author eugene zadyra
 */
public class PostgreSqlDropDataBaseCommand extends AbstractCommand {
	public PostgreSqlDropDataBaseCommand(ConnectionPropertiesVO propertiesVO) {
		setCommand(String.format("dropdb -h %s -p %s %s",
				propertiesVO.getHost(),
				propertiesVO.getPort(),
				propertiesVO.getDbName()));
		addEnvironmentVariable("PGUSER", propertiesVO.getUser());
		addEnvironmentVariable("PGPASSWORD", propertiesVO.getPassword());
	}
}
