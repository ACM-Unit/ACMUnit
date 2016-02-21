package services;

import database.DataService;
import org.apache.log4j.Logger;

import javax.servlet.ServletContext;

/**
 * @author nata
 * @version 1.0
 */
public final class WebtasksServiceManager {
	private static final Logger LOGGER = Logger.getLogger(WebtasksServiceManager.class);
	private static final String WEBTASKS_SERVICES_MANAGER = "WEBTASKS_SERVICES_MANAGER";
	private static final WebtasksServiceManager INSTANCE = new WebtasksServiceManager();
	private WebtasksServiceManager() {
		init();
	}
	public static WebtasksServiceManager getInstance (ServletContext context) {
		WebtasksServiceManager instance = (WebtasksServiceManager) context.getAttribute(WEBTASKS_SERVICES_MANAGER);
		if(instance == null) {
			context.setAttribute(WEBTASKS_SERVICES_MANAGER, INSTANCE);
			instance = INSTANCE;
		}
		return instance;
	}
	
	private DataService dataService;
	public DataService getDataService() {
		return dataService;
	}
	
	private void init() {
		dataService = new DataService();
	}
	
	public void startAllServices(){
		try {
			dataService.init();
		} catch (Exception e) {
			LOGGER.info("Context can't started. '"+e.getMessage());
			throw new RuntimeException("Context can't started. '"+e.getMessage(), e);
		}
		LOGGER.info("All services have been started");
	}
	
	public void closeAllServices (){
		dataService.close();
		LOGGER.info("All services have been closed");
	}
}
