package com.ezadyra.tools.daotesthelper.loader.factory;

import com.ezadyra.tools.daotesthelper.exception.UnsupportedDataBaseEngineException;
import com.ezadyra.tools.daotesthelper.loader.DumpLoader;
import com.ezadyra.tools.daotesthelper.loader.MySqlDumpLoader;
import com.ezadyra.tools.daotesthelper.loader.PostgreSqlDumpLoader;
import com.ezadyra.tools.daotesthelper.loader.vo.ConnectionPropertiesVO;

/**
 * @author eugene zadyra
 */
public class DumpLoaderFactory {
	public static DumpLoader createDumpLoader(ConnectionPropertiesVO properties) throws UnsupportedDataBaseEngineException {
		if(properties.getDbEngine().contains("mysql")){
			return new MySqlDumpLoader(properties);
		} else if(properties.getDbEngine().contains("postgresql")){
			return new PostgreSqlDumpLoader(properties);
		}
		throw new UnsupportedDataBaseEngineException(
				String.format("Unsupported engine: %s", properties.getDbEngine()));
	}
}
