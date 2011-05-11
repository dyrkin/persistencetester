package com.eugenezadyra.tools.daotesthelper.loader;

import java.io.IOException;

/**
 * @author eugene zadyra
 */
public interface DumpLoader {
	public void loadDumps(String[] dumpList) throws IOException, InterruptedException;
}
