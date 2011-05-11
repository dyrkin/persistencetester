package com.eugenezadyra.tools.daotesthelper.command.postgresql;

import com.eugenezadyra.tools.daotesthelper.command.AbstractCommand;
import com.eugenezadyra.tools.daotesthelper.loader.vo.ConnectionPropertiesVO;

/**
 * @author eugene zadyra
 */
public class PostgreSqlCreateDataBaseCommand extends AbstractCommand {
	public PostgreSqlCreateDataBaseCommand(ConnectionPropertiesVO propertiesVO) {
		setCommand(String.format("createdb -h %s -p %s %s",
				propertiesVO.getHost(),
				propertiesVO.getPort(),
				propertiesVO.getDbName()));
		addEnvironmentVariable("PGUSER", propertiesVO.getUser());
		addEnvironmentVariable("PGPASSWORD", propertiesVO.getPassword());
	}
}