package dao.impl;

import java.util.List;

import dao1.RoleDao;
import database.DataService;
import entity.Role;

public class RoleDaoImpl implements RoleDao{
	private DataService DataService = new DataService();

	@Override
	public List<Role> getRoles() {	
		return DataService.getAllRoles();
	}

	@Override
	public List<Role> getRoleById(int id) {
		
		return DataService.getRolesById(id);
	}
	
	

}
