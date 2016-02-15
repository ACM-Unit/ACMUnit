package database;

import constants.Constants;
import models.Account;
import models.Role;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class DataService {
	private static final Logger LOGGER = Logger
			.getLogger(DataService.class);
	private static List<DBConnection> conPool = new ArrayList<DBConnection>();
	private static Object monitor = new Object();

	public boolean init() {
		try{
			LOGGER.info("init database");
			for (int i = 0; i < Constants.CONNECTING_POOL_SIZE; i++){
				newConnection();
			}
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}

	public DBConnection getDBConnection() {
		synchronized (monitor) {
			if (conPool.isEmpty()){
				newConnection();
			}
			DBConnection conn = conPool.remove(0);
			return conn;
		}
	}
	
	public void putDBConnection(DBConnection conn) {
		synchronized (monitor){
			conPool.add(conn);
		}
	}

	private void newConnection() {
		DBConnection conn = new DBConnection(Constants.CONNECTING_URL);
		synchronized (monitor) {
			conPool.add(conn);
		}
	}
	

	public List<Account> getAllLogins() {
		DBConnection conn = getDBConnection();
		List<Account> result = conn.getAllLogins();
		this.putDBConnection(conn);		
		return result;
	}
	
	public Account getAccountByLogin(String login){
		DBConnection conn = getDBConnection();
		Account result = conn.getAccountByLogin(login);
		this.putDBConnection(conn);
		return result;
	}
	
	public List<Role> getRolesById(int id){
		DBConnection conn = getDBConnection();
		List<Role> result = conn.getRolesById(id);
		this.putDBConnection(conn);
		return result;
		
	}
	
	public List<Integer> getIdAccountRoles(int idAccount){
		DBConnection conn = getDBConnection();
		List<Integer> idAccountRoles = conn.getIdAccountRoles(idAccount);
		this.putDBConnection(conn);
		return idAccountRoles;
	}

	public void close() {
		DBConnection conn = getDBConnection();
		conn.close();
	}
}
