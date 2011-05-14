package com.eugenezadyra.tools.persistencetester.command;

import java.io.IOException;

/**
 * @author eugene zadyra
 */
public interface Command {
	public void execute() throws IOException, InterruptedException;
}
