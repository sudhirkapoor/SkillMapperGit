package com.niit.skillmapper;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringRunner;

import com.niit.skillmapper.config.HibernateConfiguration;
import com.niit.skillmapper.dao.EmployeeSkillInterface;
import com.niit.skillmapper.dao.daoimpl.EmployeeSkillsDAO;
import com.niit.skillmapper.dao.daoimpl.SkillDAO;
import com.niit.skillmapper.model.EmployeeSkills;
import com.niit.skillmapper.model.Skill;

@RunWith(SpringRunner.class)
@SpringJUnitConfig(classes = HibernateConfiguration.class)
public class EmployeesSkillTestCase {
	@Autowired
	EmployeeSkillInterface employeeSkillInterface;

	/*
	 * @Test public void testAddSkill() {
	 * 
	 * EmployeeSkills employeeSkills = new EmployeeSkills();
	 * employeeSkills.setEmpid(1); employeeSkills.setBuildtool("Maven");
	 * employeeSkills.setDatabase("H2"); employeeSkills.setFramework("Spring");
	 * employeeSkills.setGraduation("BCA"); employeeSkills.setHigher("12 pass");
	 * employeeSkills.setInter("10th class"); employeeSkills.setMasters("BCA");
	 * employeeSkills.setOs("Windows");
	 * employeeSkills.setProgramingLanguage("Java");
	 * employeeSkills.setProjectundertaken("Flipkart"); employeeSkills.setRating(4);
	 * employeeSkills.setTestingtool("JUnit");
	 * Assert.assertEquals("Employee is added successfully", true,
	 * employeeSkillInterface.insertEmployeeSkills(employeeSkills)); }
	 */

	/*
	 * @Test public void testgetSkillByProgramingLanguage() {
	 * 
	 * Assert.assertNotNull("Data Reterived",
	 * employeeSkillInterface.getEmployeeSkillsByDataBase("H2")); }
	 */
	@Test
	public void testlist() {
		employeeSkillInterface.listdemo();
	}

}
