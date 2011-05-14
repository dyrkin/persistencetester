package com.eugenezadyra.tools.persistencetester.command.mysql;

import com.eugenezadyra.tools.persistencetester.command.AbstractCommand;
import com.eugenezadyra.tools.persistencetester.loader.vo.ConnectionPropertiesVO;

/**
 * @author eugene zadyra
 */
public class MySqlCreateDataBaseCommand extends AbstractCommand {
	public MySqlCreateDataBaseCommand(ConnectionPropertiesVO propertiesVO) {
		setCommand(String.format("mysqladmin -u%s -p%s -h%s -P%s -f create %s",
				propertiesVO.getUser(),
				propertiesVO.getPassword(),
				propertiesVO.getHost(),
				propertiesVO.getPort(),
				propertiesVO.getDbName()));
	}
}
