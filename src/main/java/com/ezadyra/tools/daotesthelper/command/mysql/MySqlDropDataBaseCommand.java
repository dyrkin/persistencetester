package com.ezadyra.tools.daotesthelper.command.mysql;

import com.ezadyra.tools.daotesthelper.command.AbstractCommand;
import com.ezadyra.tools.daotesthelper.loader.vo.ConnectionPropertiesVO;

/**
 * @author eugene zadyra
 */
public class MySqlDropDataBaseCommand extends AbstractCommand{
	public MySqlDropDataBaseCommand(ConnectionPropertiesVO propertiesVO){
		setCommand(String.format("mysqladmin -u%s -p%s -h%s -P%s -f drop %s",
                propertiesVO.getUser(),
				propertiesVO.getPassword(),
				propertiesVO.getHost(),
				propertiesVO.getPort(),
				propertiesVO.getDbName()));
	}
}
