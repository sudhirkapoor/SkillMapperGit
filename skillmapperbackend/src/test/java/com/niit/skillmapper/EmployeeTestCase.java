package com.niit.skillmapper;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringRunner;

import com.niit.skillmapper.config.AppInitializer;
import com.niit.skillmapper.config.HibernateConfiguration;
import com.niit.skillmapper.dao.daoimpl.EmployeeDAO;
import com.niit.skillmapper.dao.EmployeeDAOInterface;
import com.niit.skillmapper.model.Employees;

@RunWith(SpringRunner.class)
@SpringJUnitConfig(classes = HibernateConfiguration.class)
public class EmployeeTestCase {
	@Autowired
	EmployeeDAOInterface employeeDAOInterface;

	@Test
	public void testAddEmployee() {
		Employees emp = new Employees();
		emp.setEmpid(1);
		emp.setEmpname("Anjali");
		emp.setBusinessunit("CEB");
		emp.setDateofjoining("15/05/2009");
		emp.setDepartment("Own Centre");
		emp.setEmailid("Anjali@niit.com");
		emp.setManagerid(1);
		emp.setPassword("password");
		emp.setRegion("R02");
		emp.setRole("AL");
		emp.setStatus("Inactive");
		emp.setTtlstudenttaught(5000);
		emp.setTtlyearofexp(9);
		Assert.assertEquals("Employee is added successfully",1, employeeDAOInterface.insertEmployee(emp));
	}
	
	@Test
	public void testupdateEmployee() {
		Employees emp = new Employees();
		
		emp.setEmpid(3);
		emp.setEmpname("Sudhir Kapoor");
		emp.setBusinessunit("CEB");
		emp.setDateofjoining("15/05/2009");
		emp.setDepartment("Own Centre");
		emp.setEmailid("sudhir.kapoor@niit.com");
		emp.setManagerid(1);
		emp.setPassword("password");
		emp.setRegion("R02");
		emp.setRole("AL");
		emp.setStatus("Inactive");
		emp.setTtlstudenttaught(5000);
		emp.setTtlyearofexp(8);
		Assert.assertEquals("Employee is added successfully",1, employeeDAOInterface.updateEmployee(emp));
	}
	
	@Test
	public void testdeleteEmployee() {
		Employees emp = new Employees();
		
		emp.setEmpid(1);
		Assert.assertEquals("Employee is added successfully",1, employeeDAOInterface.deleteEmployee(emp.getEmpid()));
	}
	
	@Test
	public void testgetAllEmployee() {
		List<Employees> emplist=null;
		emplist=employeeDAOInterface.getAllEmployee();
	}
}
