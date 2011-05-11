package com.eugenezadyra.tools.daotesthelper.command;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @author eugene zadyra
 */
public class AbstractCommand implements Command {
	private static final Logger log = LoggerFactory.getLogger(AbstractCommand.class);
	private String command;
	private Map<String, String> environmentVariables;

	public void execute() throws IOException, InterruptedException {
		System.out.println(String.format("Command: %s", command));
		new CommandExecutor(command, environmentVariables).execute();
	}

	protected void setCommand(String command) {
		this.command = command;
	}

	public void addEnvironmentVariable(String variable, String value) {
		if (environmentVariables == null) {
			environmentVariables = new HashMap<String, String>();
		}
		environmentVariables.put(variable, value);
	}
}
