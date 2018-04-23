package com.niit.skillmapper.dao;

import java.util.List;

import org.hibernate.Session;

import com.niit.skillmapper.model.Employee;

public interface EmployeeDAOInterface {

	public int insertEmployee(Employee employee);
	public int updateEmployee(Employee employee);
	public int deleteEmployee(int employeeId);
	public Employee getEmployeeById(int employeeId);
	public List<Employee> getAllEmployee();
	public boolean loginValidate(int employeeId, String password);
	public boolean approveEmployeeByHR(int employeeId);
	public List<Employee> getEmployeeByLocation(String location);
	public List<Employee> getEmployeeByRegion(String region);
	public List<Employee> getEmployeeByBusinessUnit(String businessUnit);
	public List<Employee> getEmployeeByDepartment(String department);
	public List<Employee> getEmployeeByRole(String role);
	public List<Employee> getAllEmployeesByMultipleSkillName(String skillName);

	/*	public List<Employees> getEmployeeByOS(String os);
	public List<Employees> getEmployeeByDataBase(String database);
	public List<Employees> getEmployeeByFramework(String framework);
	public List<Employees> getEmployeeByTestingTool(String testingTool);
	public List<Employees> getEmployeeByBuildTool(String buildTool);
	public List<Employees> getEmployeeByPrograminLanguage(String programingLanguage);
*/	
}
