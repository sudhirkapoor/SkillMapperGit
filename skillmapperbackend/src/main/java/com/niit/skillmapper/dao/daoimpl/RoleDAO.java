package com.niit.skillmapper.dao.daoimpl;

import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.skillmapper.dao.RoleDAOInterface;
import com.niit.skillmapper.model.Employees;
import com.niit.skillmapper.model.Role;

@Repository
@Transactional
public class RoleDAO implements RoleDAOInterface {

	@Autowired
	SessionFactory sessionFactory;

	public boolean addRole(Role role) {

		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().save(role);
			return true;
		} catch (Exception e) {
			e.printStackTrace();

		}
		return false;
	}

	public boolean updateRole(Role role) {
		try {
			sessionFactory.getCurrentSession().update(role);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			;
		}
		return false;
	}

	public boolean deleteRole(int roleId) {
		try {

			Session session = sessionFactory.getCurrentSession();
			Role role = (Role) session.load(Role.class, new Integer(roleId));
			session.delete(role);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

	public List<Role> getAllRole() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Role");
		List<Role> roleList = query.getResultList();
		return roleList;
	}

	public Role getRoleById(int roleId) {

		Session session = sessionFactory.getCurrentSession();
		Role role = (Role) session.get(Role.class, new Integer(roleId));
		return role;

	}

	public Role getRoleByName(String roleName) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Role where roleName='" + roleName + "'");
		Role role = (Role) query.getResultList();
		return role;

	}

}
