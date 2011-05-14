package com.eugenezadyra.tools.persistencetester.command.postgresql;

import com.eugenezadyra.tools.persistencetester.command.AbstractCommand;
import com.eugenezadyra.tools.persistencetester.loader.vo.ConnectionPropertiesVO;

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
