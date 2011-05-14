package com.eugenezadyra.tools.persistencetester.loader;

import com.eugenezadyra.tools.persistencetester.command.Command;
import com.eugenezadyra.tools.persistencetester.command.CommandHolder;
import com.eugenezadyra.tools.persistencetester.command.mysql.MySqlCreateDataBaseCommand;
import com.eugenezadyra.tools.persistencetester.command.mysql.MySqlDropDataBaseCommand;
import com.eugenezadyra.tools.persistencetester.command.mysql.MySqlImportDumpCommand;
import com.eugenezadyra.tools.persistencetester.loader.vo.ConnectionPropertiesVO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author eugene zadyra
 */
public class MySqlDumpLoader extends AbstractDumpLoader implements DumpLoader {
	private ConnectionPropertiesVO properties;

	public MySqlDumpLoader(ConnectionPropertiesVO properties) {
		this.properties = properties;
	}

	@Override
	public void loadDumps(String[] dumpList) throws IOException, InterruptedException {
		CommandHolder commandHolder = new CommandHolder();
		commandHolder.setCreateCommand(new MySqlCreateDataBaseCommand(properties));
		commandHolder.setDropCommand(new MySqlDropDataBaseCommand(properties));
		List<Command> importCommands = new ArrayList<Command>();
		for (String dump : dumpList) {
			importCommands.add(new MySqlImportDumpCommand(properties, dump));
		}
		commandHolder.setImportCommand(importCommands);
		loadDumps(commandHolder);
	}
}
