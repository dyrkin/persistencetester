package com.eugenezadyra.tools.daotesthelper.command.shell;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.Map;


/**
 * @author eugene zadyra
 */
public class ShellProcess {
	private static final Logger log = LoggerFactory.getLogger(ShellProcess.class);
	private BufferedReader inputReader;
	private PrintWriter output;

	private Process process;
	private ProcessBuilder processBuilder;
	private StringBuilder outputLog = new StringBuilder();

	public ShellProcess(String shell, String command, Map<String, String> envVariables) throws IOException {
		processBuilder = new ProcessBuilder(shell);
		if (envVariables != null) {
			processBuilder.environment().putAll(envVariables);
		}
		processBuilder.redirectErrorStream(true);
		process = processBuilder.start();
		inputReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
		output = new PrintWriter(new BufferedOutputStream(process.getOutputStream()));
		output.println(command);
		output.flush();
	}

	public void readOutput() throws IOException, InterruptedException {
		int iterations=0;
		while (!inputReader.ready()) {
			Thread.sleep(100);
			if(iterations++ >= 20){
				break;
			}
		}
		while (inputReader.ready()) {
			outputLog.append(inputReader.readLine());
			Thread.sleep(5l);
		}
	}

	public String getOutputLog() {
		return outputLog.toString();
	}

	@Override
	public String toString() {
		return outputLog.toString();
	}

	public int waitFor() throws InterruptedException {
		output.println("exit");
		output.flush();
		return process.waitFor();
	}

	public void destroy() {
		if (process != null) {
			process.destroy();
		}
	}
}
