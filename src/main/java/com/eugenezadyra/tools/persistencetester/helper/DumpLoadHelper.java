package com.eugenezadyra.tools.persistencetester.helper;

import com.eugenezadyra.tools.persistencetester.common.Consts;
import com.eugenezadyra.tools.persistencetester.exception.UnsupportedDataBaseEngineException;
import com.eugenezadyra.tools.persistencetester.loader.factory.ConnectionPropertiesFactory;
import com.eugenezadyra.tools.persistencetester.loader.factory.DumpLoaderFactory;
import com.eugenezadyra.tools.persistencetester.loader.vo.ConnectionPropertiesVO;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author eugene zadyra
 */
public class DumpLoadHelper {
	private static final Logger log = LoggerFactory.getLogger(ConnectionPropertiesFactory.class);

	private ConnectionPropertiesVO properties;
	private String[] dumpFileNameList;

	public DumpLoadHelper(String dumpFileName) {
		initVariables(Consts.DEFAULT_PROPERTIES_FILE_NAME, new String[]{dumpFileName});
	}

	public DumpLoadHelper(String propertiesFileName, String dumpFileName) {
		initVariables(propertiesFileName, new String[]{dumpFileName});
	}

	public DumpLoadHelper(String[] dumpFileNameList) {
		initVariables(Consts.DEFAULT_PROPERTIES_FILE_NAME, dumpFileNameList);
	}

	public DumpLoadHelper(String propertiesFileName, String[] dumpFileNameList) {
		initVariables(propertiesFileName, dumpFileNameList);
	}

	private void initVariables(String propertiesFileName, String[] dumpFileNameList) {
		this.dumpFileNameList = dumpFileNameList;
		this.properties = createConnectionProperties(propertiesFileName);
	}

	public void load() {
		try {
			DumpLoaderFactory.createDumpLoader(properties).loadDumps(dumpFileNameList);
		} catch (UnsupportedDataBaseEngineException e) {
			log.error(e.getMessage());
		} catch (InterruptedException e) {
			log.error(e.getMessage());
		} catch (IOException e) {
			log.error(e.getMessage());
		}
	}

	private ConnectionPropertiesVO createConnectionProperties(String propertiesFileName) {
		return new ConnectionPropertiesFactory().createConnectionPropertiesVO(loadConnectionProperties(propertiesFileName));
	}

	private Properties loadConnectionProperties(String propertiesFileName) {
		InputStream stream = getClass().getClassLoader().getResourceAsStream(propertiesFileName);
		Properties properties = new Properties();
		try {
			properties.load(stream);
			return properties;
		} catch (IOException e) {
			throw new IllegalStateException(e);
		} finally {
			IOUtils.closeQuietly(stream);
		}
	}

}
