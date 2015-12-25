package entity;

import java.util.List;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

import org.apache.log4j.Logger;



public class Account extends AbstractModelBean implements HttpSessionBindingListener {
	private static final Logger LOGGER = Logger.getLogger(Account.class);
	private static final long serialVersionUID = -5787220666753301113L;
	private int id;
	private String login;
	private String password;
	private List<Role> roles;
	public Account() {
		super();
	}
	public Account(String login, String password) {
		super();
		this.login = login;
		this.password = password;
	}
	
	public Account(int id, String username, String password, List<Role> roles) {
		super();
		this.id = id;
		this.login = username;
		this.password = password;
		this.setRoles(roles);
	}
	
	public int getId() {
		return this.id;
	}
	
	public void setId(Integer id){
		this.id = id;
	}
	public void setId(int id) {
		this.id = id;
	}

	
	public String getUsername() {
		return login;
	}
	public void setUsername(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	protected Object getIdModel() {
		return getUsername();
	}
	@Override
	public void valueBound(HttpSessionBindingEvent se) {
		if(LOGGER.isDebugEnabled()) {
			StringBuilder message = new StringBuilder("Account has been added to session with id='");
			message.append(se.getSession().getId());
			message.append("' and been bound to name='");
			message.append(se.getName());
			message.append("'");
			LOGGER.debug(message);
		}
	}
	@Override
	public void valueUnbound(HttpSessionBindingEvent se) {
		if(LOGGER.isDebugEnabled()) {
			StringBuilder message = new StringBuilder("Account has been removed from session with id='");
			message.append(se.getSession().getId());
			message.append("'");
			LOGGER.debug(message);
		}
	}
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
}
