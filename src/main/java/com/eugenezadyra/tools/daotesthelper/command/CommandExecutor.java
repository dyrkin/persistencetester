package com.eugenezadyra.tools.daotesthelper.command;

import com.eugenezadyra.tools.daotesthelper.command.shell.Shell;
import com.eugenezadyra.tools.daotesthelper.command.shell.ShellProcess;
import com.eugenezadyra.tools.daotesthelper.exception.UnsupportedOperatingSystemException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.Map;

/**
 * @author eugene zadyra
 */
public class CommandExecutor {
	private static final Logger log = LoggerFactory.getLogger(CommandExecutor.class);

	private String command;
	Map<String, String> envVariables;


	public CommandExecutor(String command, Map<String, String> envVariables) {
		this.command = command;
		this.envVariables = envVariables;
	}

	public void execute() throws InterruptedException, IOException {
		ShellProcess process = null;
		try {
			process = new Shell().execute(command, envVariables);
			process.readOutput();
			System.out.println(process.getOutputLog());
			if (process.waitFor() != 0) {

			}
		} catch (UnsupportedOperatingSystemException e) {
			log.error(e.getMessage());
		} finally {
			if (process != null) {
				process.destroy();
			}
		}
	}
}
