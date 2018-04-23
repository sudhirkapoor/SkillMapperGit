package com.niit.skillmapper.dao;

import java.util.List;

import com.niit.skillmapper.model.Employee;
import com.niit.skillmapper.model.Skill;

public interface SkillDAOInterface {

	public	boolean addSkill(Skill skill);
	public	boolean updateSkill(Skill skill);
	public	List<Skill> getAllSkillsOfEmployee(int employeeId);
	public	boolean removeSkill(int skillId);
	public	List<Skill> getSkillsById(int skillId);
	public	List<Skill> getAllSkills();
}
