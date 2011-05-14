package com.eugenezadyra.tools.persistencetester.loader;

import com.eugenezadyra.tools.persistencetester.command.Command;
import com.eugenezadyra.tools.persistencetester.command.CommandHolder;
import com.eugenezadyra.tools.persistencetester.command.postgresql.PostgreSqlCreateDataBaseCommand;
import com.eugenezadyra.tools.persistencetester.command.postgresql.PostgreSqlDropDataBaseCommand;
import com.eugenezadyra.tools.persistencetester.command.postgresql.PostgreSqlImportDumpCommand;
import com.eugenezadyra.tools.persistencetester.loader.vo.ConnectionPropertiesVO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author eugene zadyra
 */
public class PostgreSqlDumpLoader extends AbstractDumpLoader implements DumpLoader {
	private ConnectionPropertiesVO properties;

	public PostgreSqlDumpLoader(ConnectionPropertiesVO properties) {
		this.properties = properties;
	}

	@Override
	public void loadDumps(String[] dumpList) throws IOException, InterruptedException {
		CommandHolder commandHolder = new CommandHolder();
		commandHolder.setCreateCommand(new PostgreSqlCreateDataBaseCommand(properties));
		commandHolder.setDropCommand(new PostgreSqlDropDataBaseCommand(properties));
		List<Command> importCommands = new ArrayList<Command>();
		for (String dump : dumpList) {
			importCommands.add(new PostgreSqlImportDumpCommand(properties, dump));
		}
		commandHolder.setImportCommand(importCommands);
		loadDumps(commandHolder);
	}
}
