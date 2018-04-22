package com.niit.skillmapper.dao;

import java.util.List;

import com.niit.skillmapper.model.Employees;
import com.niit.skillmapper.model.Skill;

public interface SkillDAOInterface {

	boolean addSkill(Skill skill);
	boolean addEmployeeSkill(int skillId,int employeeId);
	List<Employees> getAllEmployeesBySkillName(String skillName);
	List<Skill> getAllSkillsOfEmployee(int employeeId);
	boolean removeSkill(Skill skill);
	boolean deleteEmployeeSkill(int skillId,int employeeId);

}
