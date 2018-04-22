package com.niit.skillmapper.dao;

import java.util.List;

import org.hibernate.Session;

import com.niit.skillmapper.model.Employees;

public interface EmployeeDAOInterface {

	public int insertEmployee(Employees emp);
	public int updateEmployee(Employees emp);
	public int deleteEmployee(int empid);
	public Employees getEmployee(int empid);
	public List<Employees> getAllEmployee();
	public boolean changeStatus(int empid);
	public List<Employees> getEmployeeByManagerId(int managerId);
	public boolean loginValidate(int empid, String password);
	public boolean approveUser(int empId);
}
