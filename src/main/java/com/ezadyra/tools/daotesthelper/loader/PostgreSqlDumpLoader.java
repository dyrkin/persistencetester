package com.ezadyra.tools.daotesthelper.loader;

import com.ezadyra.tools.daotesthelper.command.Command;
import com.ezadyra.tools.daotesthelper.command.CommandHolder;
import com.ezadyra.tools.daotesthelper.command.mysql.MySqlCreateDataBaseCommand;
import com.ezadyra.tools.daotesthelper.command.mysql.MySqlDropDataBaseCommand;
import com.ezadyra.tools.daotesthelper.command.mysql.MySqlImportDumpCommand;
import com.ezadyra.tools.daotesthelper.command.postgresql.PostgreSqlCreateDataBaseCommand;
import com.ezadyra.tools.daotesthelper.command.postgresql.PostgreSqlDropDataBaseCommand;
import com.ezadyra.tools.daotesthelper.command.postgresql.PostgreSqlImportDumpCommand;
import com.ezadyra.tools.daotesthelper.loader.vo.ConnectionPropertiesVO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author eugene zadyra
 */
public class PostgreSqlDumpLoader  extends AbstractDumpLoader implements DumpLoader{
		private ConnectionPropertiesVO properties;

	public PostgreSqlDumpLoader(ConnectionPropertiesVO properties){
		this.properties = properties;
	}

	@Override
	public void loadDumps(String[] dumpList) throws IOException, InterruptedException {
		CommandHolder commandHolder = new CommandHolder();
		commandHolder.setCreateCommand(new PostgreSqlCreateDataBaseCommand(properties));
		commandHolder.setDropCommand(new PostgreSqlDropDataBaseCommand(properties));
		List<Command> importCommands = new ArrayList<Command>();
		for(String dump: dumpList){
			importCommands.add(new PostgreSqlImportDumpCommand(properties, dump));
		}
		commandHolder.setImportCommand(importCommands);
		loadDumps(commandHolder);
	}
}
