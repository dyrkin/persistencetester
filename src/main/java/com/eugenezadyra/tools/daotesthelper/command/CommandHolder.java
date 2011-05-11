package com.eugenezadyra.tools.daotesthelper.command;

import java.util.List;

/**
 * @author eugene zadyra
 */
public class CommandHolder {
	private Command dropCommand;
	private Command createCommand;
	private List<Command> importCommand;

	public Command getDropCommand() {
		return dropCommand;
	}

	public void setDropCommand(Command dropCommand) {
		this.dropCommand = dropCommand;
	}

	public Command getCreateCommand() {
		return createCommand;
	}

	public void setCreateCommand(Command createCommand) {
		this.createCommand = createCommand;
	}

	public List<Command> getImportCommandList() {
		return importCommand;
	}

	public void setImportCommand(List<Command> importCommand) {
		this.importCommand = importCommand;
	}
}
