package listeners;

import org.apache.log4j.Logger;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * @author nata
 * @version 1.0
 */
public class WebtasksSessionListener implements HttpSessionListener {
	private static final Logger LOGGER = Logger.getLogger(WebtasksSessionListener.class);
	
	@Override
	public void sessionCreated(HttpSessionEvent se) {
		HttpSession session = se.getSession();
		if(LOGGER.isDebugEnabled()) {
			LOGGER.debug("A new session with id='"+session.getId()+"' has been created");
		}
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		HttpSession session = se.getSession();
		if(LOGGER.isDebugEnabled()) {
			LOGGER.debug("Session with id='"+session.getId()+"' has been destroyed");
		}
	}
}
