/*package com.niit.skillmapper;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringRunner;

import com.niit.skillmapper.config.HibernateConfiguration;
import com.niit.skillmapper.dao.daoimpl.EmployeeDAO;
import com.niit.skillmapper.dao.EmployeeDAOInterface;
import com.niit.skillmapper.model.Employee;

@RunWith(SpringRunner.class)
@SpringJUnitConfig(classes = HibernateConfiguration.class)
public class EmployeeTestCase {
	@Autowired
	EmployeeDAOInterface employeeDAOInterface;

	@Test
	public void testAddEmployee() {
		Employee emp = new Employee();
		emp.setEmployeeId(3);
		emp.setEmployeeName("Aradhna");
		emp.setBusinessUnit("CEB");
		emp.setDateOfJoining("15/05/2009");
		emp.setDepartment("Own Centre");
		emp.setEmailId("Aradhna@niit.com");
		emp.setLocation("Delhi");
		emp.setManagerId(1);
		emp.setPassword("password");
		emp.setRegion("R02");
		emp.setRole("AL");
		emp.setStatus("Inactive");
		emp.setTotalStudentsTaught(5000);
		emp.setTotalYearsOfExp(9);
		
		emp.setHigherSchool("12 pass");
		emp.setInterClassDetail("10th class");
		emp.setGraduation("BCA");
		
		emp.setProjectUnderTaken("Flipkart");
		emp.setGender("Female");
		emp.setContactNumber("9898989898");
		
		Assert.assertEquals("Employee is added successfully",1, employeeDAOInterface.insertEmployee(emp));
	}
	
	@Test
	public void testupdateEmployee() {
		Employee emp = new Employee();
		
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
	
	@Test
	public void testgetEmployeeByRegion() {
		List<Employee> emplist=null;
		emplist=employeeDAOInterface.getEmployeeByRegion("Delhi");
		Assert.assertNotNull("Values are reterived", emplist);
	}
	
	@Test
	public void testskill()
	{
		Assert.assertNotNull(employeeDAOInterface.getAllEmployeesByMultipleSkillName("Java"));
	}
}
*/