package com.ezadyra.tools.daotesthelper.loader;

import com.ezadyra.tools.daotesthelper.command.Command;
import com.ezadyra.tools.daotesthelper.command.CommandHolder;
import com.ezadyra.tools.daotesthelper.loader.vo.ConnectionPropertiesVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * @author eugene zadyra
 */
public class AbstractDumpLoader{
	private static Logger log = LoggerFactory.getLogger(AbstractDumpLoader.class);

	public void loadDumps(CommandHolder commandHolder) throws IOException, InterruptedException {
		try{
			commandHolder.getDropCommand().execute();
		} catch (Exception e){
			log.info("Can't drop database because it doesn't exists");
		}
		commandHolder.getCreateCommand().execute();
		for(Command importCommand: commandHolder.getImportCommandList()){
		  	importCommand.execute();
		}
	}
}
