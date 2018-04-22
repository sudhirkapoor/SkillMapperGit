package com.niit.skillmapper.dao;

import java.util.List;

import com.niit.skillmapper.model.Role;

public interface RoleDAOInterface {
	boolean addRole(Role role);
	boolean updateRole(Role role);
	boolean deleteRole(int roleId);
	List<Role> getAllRole();
	Role getRoleById(int roleId);
	Role getRoleByName(String roleName);
}