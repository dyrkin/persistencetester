package com.ezadyra.tools.daotesthelper.command.postgresql;

import com.ezadyra.tools.daotesthelper.command.AbstractCommand;
import com.ezadyra.tools.daotesthelper.loader.vo.ConnectionPropertiesVO;

import java.io.File;

/**
 * @author eugene zadyra
 */
public class PostgreSqlImportDumpCommand extends AbstractCommand {
	public PostgreSqlImportDumpCommand(ConnectionPropertiesVO propertiesVO, String dump) {
		File file = new File(PostgreSqlImportDumpCommand.class.getClassLoader().getResource(dump).getFile());
		setCommand(String.format("psql -h %s -p %s %s -f %s",
				propertiesVO.getHost(),
				propertiesVO.getPort(),
				propertiesVO.getDbName(),
				file.getAbsolutePath()));
		addEnvironmentVariable("PGUSER", propertiesVO.getUser());
		addEnvironmentVariable("PGPASSWORD", propertiesVO.getPassword());
	}
}
