package dao1;

import java.util.List;

import entity.Account;
import entity.Role;

public interface AccountDao {
	
	Account getAccountByLogin(String login);
	
	List<Role> getAccountRoles(int idAccount);

}
