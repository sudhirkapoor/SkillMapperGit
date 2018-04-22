package com.niit.skillmapper.dao.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.skillmapper.dao.EmployeeDAOInterface;
import com.niit.skillmapper.model.Employees;
import com.niit.skillmapper.model.Role;

@Repository
@Transactional
public class EmployeeDAO implements EmployeeDAOInterface {

	@Autowired
	SessionFactory sessionFactory;
	/*
	 * public EmployeeDAO() {
	 * 
	 * }
	 */

	public int insertEmployee(Employees emp) {
		// boolean result = false;
		int result = 0;
		try {
			sessionFactory.getCurrentSession().save(emp);
			result = 1;
		} catch (Exception e) {
			e.printStackTrace();
			result = 0;
		}
		return result;

	}

	public int updateEmployee(Employees emp) {
		int result = 0;
		try {
			sessionFactory.getCurrentSession().update(emp);
			result = 1;
		} catch (Exception e) {
			// TODO: handle exception
			;
		}
		return result;

	}

	public int deleteEmployee(int empid) {
		int result = 0;
		try {

			Session session = sessionFactory.getCurrentSession();
			Employees emp = (Employees) session.load(Employees.class, new Integer(empid));
			session.delete(emp);
			result = 1;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

	public Employees getEmployee(int empid) {

		Session session = sessionFactory.getCurrentSession();
		Employees employee = (Employees) session.get(Employees.class, new Integer(empid));
		return employee;
	}

	public List<Employees> getAllEmployee() {
		Query query = sessionFactory.getCurrentSession().createQuery("from Employees");

		List<Employees> employeelist = query.getResultList();
		for (Employees employee : employeelist) {
			System.out.println("Name:-" + employee.getEmpname());
		}
		return employeelist;
	}

	public boolean changeStatus(int empid) {
		try {

			Session session = sessionFactory.getCurrentSession();
			Employees emp = (Employees) session.load(Employees.class, new Integer(empid));
			emp.setStatus("Active");
			session.update(emp);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		}

		return false;
	}

	public List<Employees> getEmployeeByManagerId(int managerId) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Employees where managerid='" + managerId + "'");
		List<Employees> employeeList = query.getResultList();
		return employeeList;
	}

	public boolean loginValidate(int empid, String password) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean approveUser(int empId) {
		return false;
	}
}
