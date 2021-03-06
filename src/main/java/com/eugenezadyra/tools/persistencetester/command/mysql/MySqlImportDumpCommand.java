package com.eugenezadyra.tools.persistencetester.command.mysql;

import com.eugenezadyra.tools.persistencetester.command.AbstractCommand;
import com.eugenezadyra.tools.persistencetester.loader.vo.ConnectionPropertiesVO;

import java.io.File;

/**
 * @author eugene zadyra
 */
public class MySqlImportDumpCommand extends AbstractCommand {
	public MySqlImportDumpCommand(ConnectionPropertiesVO propertiesVO, String dump) {
		File file = new File(MySqlImportDumpCommand.class.getClassLoader().getResource(dump).getFile());
		setCommand(String.format("mysql -u%s -p%s -h%s -P%s %s < %s",
				propertiesVO.getUser(),
				propertiesVO.getPassword(),
				propertiesVO.getHost(),
				propertiesVO.getPort(),
				propertiesVO.getDbName(),
				file.getAbsolutePath()));
	}
}
