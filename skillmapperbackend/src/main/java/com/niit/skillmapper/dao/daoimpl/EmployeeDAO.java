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

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.skillmapper.dao.EmployeeDAOInterface;
import com.niit.skillmapper.model.Employee;
import com.niit.skillmapper.model.Role;
import com.niit.skillmapper.model.Skill;

@Repository
@Transactional
public class EmployeeDAO implements EmployeeDAOInterface {
	@Autowired
private	SessionFactory sessionFactory;
	
	@Autowired
	private EmployeeDAOInterface employeeDAOInterface; 
	/*
	 * public EmployeeDAO() {
	 * 
	 * }
	 */

	public int insertEmployee(Employee emp) {
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

	public int updateEmployee(Employee emp) {
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

	public int deleteEmployee(int employeeId) {
		int result = 0;
		try {

			Session session = sessionFactory.getCurrentSession();
			Employee emp = (Employee) session.load(Employee.class, new Integer(employeeId));
			session.delete(emp);
			result = 1;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

	public Employee getEmployeeById(int employeeId) {

		Session session = sessionFactory.getCurrentSession();
		Employee employee = (Employee) session.get(Employee.class, new Integer(employeeId));
		return employee;
	}

	public List<Employee> getAllEmployee() {
		Query query = sessionFactory.getCurrentSession().createQuery("from Employee");

		List<Employee> employeelist = query.getResultList();
		
		return employeelist;
	}

	public boolean approveEmployeeByHR(int employeeId) {
		try {

			Session session = sessionFactory.getCurrentSession();
			Employee emp = (Employee) session.load(Employee.class, new Integer(employeeId));
			emp.setStatus("Active");
			session.update(emp);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		}

		return false;
	}

	public List<Employee> getEmployeeByManagerId(int managerId) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Employee where managerid='" + managerId + "'");
		List<Employee> employeeList = query.getResultList();
		return employeeList;
	}

	
	public List<Employee> getEmployeeByLocation(String location) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Employee where location='" + location + "'");
		List<Employee> employeeList = query.getResultList();

		if (employeeList != null) {
			return employeeList;
		} else {
			return null;
		}
	}
/*
	public List<Employees> getEmployeeByDataBase(String database) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from EmployeeSkills where database='" + database + "'");
		List<Employees> employeeList = query.getResultList();

		if (employeeList != null) {
			return employeeList;
		} else {
			return null;
		}
	}

	public List<Employees> getEmployeeByFramework(String framework) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Employees where framework='" + framework + "'");
		List<Employees> employeeList = query.getResultList();
		if (employeeList != null) {
			return employeeList;
		} else {
			return null;
		}
	}

	public List<Employees> getEmployeeByTestingTool(String testingTool) {
		Session session = sessionFactory.getCurrentSession();
		System.out.println("tool start1");
		Query query = session.createQuery("from Employees where testingtool='" + testingTool + "'");
		System.out.println("tool start2");
		List<Employees> employeeList = query.getResultList();
		for (Employees employees : employeeList) {
			System.out.println(employees.getEmpname());
		}
		if (employeeList != null) {
			return employeeList;
		} else {
			return null;
		}
	}

	public List<Employees> getEmployeeByBuildTool(String buildTool) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Employees where buildtool='" + buildTool + "'");
		List<Employees> employeeList = query.getResultList();
		if (employeeList != null) {
			return employeeList;
		} else {
			return null;
		}
	}

	public List<Employees> getEmployeeByPrograminLanguage(String programingLanguage) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Employees where programinglanguage='" + programingLanguage + "'");
		List<Employees> employeeList = query.getResultList();
		if (employeeList != null) {
			return employeeList;
		} else {
			return null;
		}
	}

*/	
	@Override
	public boolean loginValidate(int empid, String password) {
		try{

			Query<Employee> query=sessionFactory.getCurrentSession().createQuery("from Employee where employeeId=:empId").setParameter("empId",empid);
			Employee user=(Employee)query.uniqueResult();
			if (user!=null)
			{   if(user.getPassword().equals(password))
				return true;
			else return false;
			}
			else
				return false;

		}
		catch(HibernateException e)
		{
			return false;
		}
	}

	
	@Override
	public List<Employee> getEmployeeByRegion(String region) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Employee where region='" + region + "'");
		List<Employee> employeeList = query.getResultList();
		if (employeeList != null) {
			return employeeList;
		} else {
			return null;
		}
	}

	@Override
	public List<Employee> getEmployeeByBusinessUnit(String businessUnit) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Employee where businessUnit='" + businessUnit + "'");
		List<Employee> employeeList = query.getResultList();
		if (employeeList != null) {
			return employeeList;
		} else {
			return null;
		}
	}

	@Override
	public List<Employee> getEmployeeByRole(String role) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Employee where role='" + role + "'");
		List<Employee> employeeList = query.getResultList();
		if (employeeList != null) {
			return employeeList;
		} else {
			return null;
		}
	}

	@Override
	public List<Employee> getEmployeeByDepartment(String department) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Employee where department='" + department + "'");
		List<Employee> employeeList = query.getResultList();
		if (employeeList != null) {
			return employeeList;
		} else {
			return null;
		}
	}
	
	
	private List<String> getAllSkills(String skills)
	{
		List<String> allSkills=new ArrayList<String>();
		String[] allStrings=skills.split(",");
		for(String s:allStrings)
		{
			String[] str=s.split(" ");
			if(str!=null)
			{
				for(String ss:str)
				if(!(ss.equals("and")||ss.equals("or")||ss.equals("the")))
				{
					allSkills.add(ss.trim());
				}
			}
		}
		
		//allSkills.forEach(System.out::println);
		return allSkills;
	}
	
	@Override
	public List<Employee> getAllEmployeesByMultipleSkillName(String skillName) {
		List<String> skillNames=getAllSkills(skillName);
		try{
			System.out.println();
			Query query = sessionFactory.getCurrentSession().createQuery("From Skill where skillName in (:skillnames)");
			query.setParameterList("skillnames", skillNames);
			List<Skill> list = query.list();
			List<Employee> empList = new ArrayList<Employee>();
			Employee emp = new Employee();
			for(Skill skill : list)
			{
				emp = employeeDAOInterface.getEmployeeById(skill.getEmployeeId());
				if(!(empList.isEmpty()))
				{
					for(Employee e:empList)
					{
						if(e.getEmployeeId()!=emp.getEmployeeId())
						{
							empList.add(emp);
						}
					}
				}
				else
				{
					empList.add(emp);
				}
			}
			return empList;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return null;
		}
		
	}
	
	
}
