package dao.impl;

import java.util.ArrayList;
import java.util.List;

import dao1.AccountDao;
import dao1.RoleDao;
import database.DataService;
import entity.Account;
import entity.Role;

public class AccountDaoImpl implements AccountDao{
	private DataService dataservice = new DataService();
	private RoleDao roleDao = new RoleDaoImpl();

	@Override
	public Account getAccountByLogin(String login) {
		Account account = dataservice.getAccountByLogin(login);
		account.setRoles(this.getAccountRoles(account.getId()));
		return account;
	}

	@Override
	public List<Role> getAccountRoles(int idAccount) {		
		List<Integer> idRoles = dataservice.getIdAccountRoles(idAccount);
		List<Role> accountRoles = new ArrayList<Role>();				
		for(Integer idRole: idRoles){
			List<Role> role = roleDao.getRoleById(idRole);
			if (role.size() != 0){
				accountRoles.add(role.get(0));
			}			
		}
		return accountRoles;
	}

}
