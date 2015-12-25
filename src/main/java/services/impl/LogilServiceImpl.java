package services.impl;

import java.util.List;

import dao.impl.AccountDaoImpl;
import dao.impl.RoleDaoImpl;
import dao1.AccountDao;
import dao1.RoleDao;
import entity.Account;
import entity.Role;
import exeptions.InvalidDataException;
import services.LoginService;

public class LogilServiceImpl implements LoginService{
	
	private AccountDao accountDao = new AccountDaoImpl();
	private RoleDao roleDao = new RoleDaoImpl();

	@Override
	public Account login(String login, String password, int role) throws InvalidDataException {
		Account accountByLogin = accountDao.getAccountByLogin(login);
		
		if (accountByLogin.getId() == 0)
			throw new InvalidDataException("notFound");
		
		if (!password.equals(accountByLogin.getPassword()))
			throw new InvalidDataException("invPass");
		
		List<Role> roles = accountByLogin.getRoles();
		List<Role> currentRole = roleDao.getRoleById(role);
		
		if (!roles.contains(currentRole.get(0)))
			throw new InvalidDataException("role");
		
		return accountByLogin;
	}

}
