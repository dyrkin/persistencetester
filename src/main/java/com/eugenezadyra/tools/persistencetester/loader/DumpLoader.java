package com.eugenezadyra.tools.persistencetester.loader;

import java.io.IOException;

/**
 * @author eugene zadyra
 */
public interface DumpLoader {
	public void loadDumps(String[] dumpList) throws IOException, InterruptedException;
}
