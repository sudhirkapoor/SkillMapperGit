package com.niit.skillmapper.dao.daoimpl;

import java.util.Iterator;
import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.property.access.spi.BuiltInPropertyAccessStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.skillmapper.dao.EmployeeSkillInterface;
import com.niit.skillmapper.model.EmployeeSkills;
import com.niit.skillmapper.model.Employees;

@Repository
@Transactional
public class EmployeeSkillsDAO implements EmployeeSkillInterface {
	@Autowired
	SessionFactory sessionFactory;

	public boolean insertEmployeeSkills(EmployeeSkills employeeSkills) {

		try {
			sessionFactory.getCurrentSession().save(employeeSkills);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

	public boolean updateEmployeeSkills(EmployeeSkills employeeSkills) {

		try {
			sessionFactory.getCurrentSession().update(employeeSkills);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

	public List<EmployeeSkills> getAllEmployeeSkills() {

		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from EmployeeSkills");
		List<EmployeeSkills> employeeSkillsList = query.getResultList();
		if (employeeSkillsList != null) {
			return employeeSkillsList;
		} else {
			return null;
		}

	}

	public List<EmployeeSkills> getEmployeeSkillsByEmpId(int empId) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from EmployeeSkills where empid='" + empId + "'");
		List<EmployeeSkills> employeeSkillsList = query.getResultList();
		if (employeeSkillsList != null) {
			return employeeSkillsList;
		} else {
			return null;
		}
	}

	public List<EmployeeSkills> getEmployeeSkillsByOS(String os) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from EmployeeSkills where os='" + os + "'");
		List<EmployeeSkills> employeeSkillsList = query.getResultList();
		if (employeeSkillsList != null) {
			return employeeSkillsList;
		} else {
			return null;
		}
	}

	public List<EmployeeSkills> getEmployeeSkillsByDataBase(String database) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from EmployeeSkills where database='" + database + "'");
		List<EmployeeSkills> employeeSkillsList = query.getResultList();

		if (employeeSkillsList != null) {
			return employeeSkillsList;
		} else {
			return null;
		}
	}

	public List<EmployeeSkills> getEmployeeSkillsByFramework(String framework) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from EmployeeSkills where framework='" + framework + "'");
		List<EmployeeSkills> employeeSkillsList = query.getResultList();
		if (employeeSkillsList != null) {
			return employeeSkillsList;
		} else {
			return null;
		}
	}

	public List<EmployeeSkills> getEmployeeSkillsByTestingTool(String testingTool) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from EmployeeSkills where testingtool='" + testingTool + "'");
		List<EmployeeSkills> employeeSkillsList = query.getResultList();
		if (employeeSkillsList != null) {
			return employeeSkillsList;
		} else {
			return null;
		}
	}

	public List<EmployeeSkills> getEmployeeSkillsByBuildTool(String buildTool) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from EmployeeSkills where buildtool='" + buildTool + "'");
		List<EmployeeSkills> employeeSkillsList = query.getResultList();
		if (employeeSkillsList != null) {
			return employeeSkillsList;
		} else {
			return null;
		}
	}

	public List<EmployeeSkills> getEmployeeSkillsByPrograminLanguage(String programingLanguage) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from EmployeeSkills where programinglanguage='" + programingLanguage + "'");
		List<EmployeeSkills> employeeSkillsList = query.getResultList();
		if (employeeSkillsList != null) {
			return employeeSkillsList;
		} else {
			return null;
		}
	}

	///////////////////// testing code
	public void listdemo() {
		Session session = sessionFactory.getCurrentSession();
		/*Criteria criteria = session.createCriteria(Employees.class);
	    criteria.setFetchMode("EmployeeSkills", FetchMode.JOIN);
	    List list = criteria.list();
	    Iterator itr=list.iterator();
	    
	    for (Object object : list) {
	    	System.out.println(object.toString());
		}*/
	    Query query=session.createQuery("from Employees e, EmployeeSkills em where e.empid=em.empid");
	    Iterator itr= 	query.getResultList().iterator();
	    System.out.println("start");
    	System.out.println(itr.next().toString());
    	System.out.println("end");
	    while(itr.hasNext()) {
	    	System.out.println("start");
	    	System.out.println(itr.next().toString());
	    	System.out.println("end");
	    }
	    
	    		
	    //from User u,Avatar a where where u.loginID = a.loginID
	    /*System.out.println("demo start");
	    System.out.println(list.get(0).toString());
	    System.out.println(list.get(1).toString());
	    System.out.println(list.get(9).toString());
	    System.out.println("demo end");*/
	}

}
