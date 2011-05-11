package com.eugenezadyra.tools.daotesthelper.loader;

import com.eugenezadyra.tools.daotesthelper.command.Command;
import com.eugenezadyra.tools.daotesthelper.command.CommandHolder;
import com.eugenezadyra.tools.daotesthelper.command.mysql.MySqlCreateDataBaseCommand;
import com.eugenezadyra.tools.daotesthelper.command.mysql.MySqlDropDataBaseCommand;
import com.eugenezadyra.tools.daotesthelper.command.mysql.MySqlImportDumpCommand;
import com.eugenezadyra.tools.daotesthelper.loader.vo.ConnectionPropertiesVO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author eugene zadyra
 */
public class MySqlDumpLoader extends AbstractDumpLoader implements DumpLoader{
	private ConnectionPropertiesVO properties;

	public MySqlDumpLoader(ConnectionPropertiesVO properties){
		this.properties = properties;
	}

	@Override
	public void loadDumps(String[] dumpList) throws IOException, InterruptedException {
		CommandHolder commandHolder = new CommandHolder();
		commandHolder.setCreateCommand(new MySqlCreateDataBaseCommand(properties));
		commandHolder.setDropCommand(new MySqlDropDataBaseCommand(properties));
		List<Command> importCommands = new ArrayList<Command>();
		for(String dump: dumpList){
			importCommands.add(new MySqlImportDumpCommand(properties, dump));
		}
		commandHolder.setImportCommand(importCommands);
		loadDumps(commandHolder);
	}
}