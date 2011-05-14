package com.eugenezadyra.tools.persistencetester.loader.factory;

import com.eugenezadyra.tools.persistencetester.exception.UnsupportedDataBaseEngineException;
import com.eugenezadyra.tools.persistencetester.loader.DumpLoader;
import com.eugenezadyra.tools.persistencetester.loader.MySqlDumpLoader;
import com.eugenezadyra.tools.persistencetester.loader.PostgreSqlDumpLoader;
import com.eugenezadyra.tools.persistencetester.loader.vo.ConnectionPropertiesVO;

/**
 * @author eugene zadyra
 */
public class DumpLoaderFactory {
	public static DumpLoader createDumpLoader(ConnectionPropertiesVO properties) throws UnsupportedDataBaseEngineException {
		if (properties.getDbEngine().contains("mysql")) {
			return new MySqlDumpLoader(properties);
		} else if (properties.getDbEngine().contains("postgresql")) {
			return new PostgreSqlDumpLoader(properties);
		}
		throw new UnsupportedDataBaseEngineException(
				String.format("Unsupported engine: %s", properties.getDbEngine()));
	}
}
