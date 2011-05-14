package com.eugenezadyra.tools.persistencetester.command.shell;

import com.eugenezadyra.tools.persistencetester.exception.UnsupportedOperatingSystemException;

import java.io.IOException;
import java.util.Map;

/**
 * @author eugene zadyra
 */
public class Shell {

	private String getShell() throws UnsupportedOperatingSystemException {
		String os = System.getProperty("os.name");
		if (os.toLowerCase().contains("linux") || os.toLowerCase().contains("mac os")) {
			return "bash";
		} else if (os.toLowerCase().contains("windows")) {
			return "cmd";
		} else {
			throw new UnsupportedOperatingSystemException(String.format("Unsupported OS: %s", os));
		}
	}

	public ShellProcess execute(String command, Map<String, String> envVariables) throws UnsupportedOperatingSystemException, IOException {
		return new ShellProcess(getShell(), command, envVariables);
	}
}
