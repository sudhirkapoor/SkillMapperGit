package com.niit.skillmapper.dao;

import java.util.List;

import com.niit.skillmapper.model.EmployeeSkills;
import com.niit.skillmapper.model.Employees;

public interface EmployeeSkillInterface {
	public boolean insertEmployeeSkills(EmployeeSkills employeeSkills);
	public boolean updateEmployeeSkills(EmployeeSkills employeeSkills);
	public List<EmployeeSkills> getAllEmployeeSkills();
	public List<EmployeeSkills> getEmployeeSkillsByEmpId(int empId);
	public List<EmployeeSkills> getEmployeeSkillsByOS(String os);
	public List<EmployeeSkills> getEmployeeSkillsByDataBase(String database);
	public List<EmployeeSkills> getEmployeeSkillsByFramework(String framework);
	public List<EmployeeSkills> getEmployeeSkillsByTestingTool(String testingTool);
	public List<EmployeeSkills> getEmployeeSkillsByBuildTool(String buildTool);
	public List<EmployeeSkills> getEmployeeSkillsByPrograminLanguage(String programingLanguage);
	public void listdemo();
	
}
