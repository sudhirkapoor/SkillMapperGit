package com.niit.skillmapper.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.niit.skillmapper.dao.SkillDAOInterface;
import com.niit.skillmapper.model.Employee;
import com.niit.skillmapper.model.Skill;

@RestController
@RequestMapping("/api/skill")
public class SkillController {

	@Autowired
	private SkillDAOInterface SkillDAOInterface;
	
	@PostMapping(value="/add")
	public ResponseEntity<Skill> insertSkill(@RequestBody Skill skill)
	{
		if(SkillDAOInterface.addSkill(skill))
		{
			return new ResponseEntity<Skill>(skill,HttpStatus.CREATED);
		}
		else
		{
			return new ResponseEntity<Skill>(skill,HttpStatus.NOT_IMPLEMENTED);
		}
	}
	
	@PutMapping(value="/update")
	public ResponseEntity<Skill> updateSkill(@RequestBody Skill skill)
	{
		if(SkillDAOInterface.updateSkill(skill))
		{
			return new ResponseEntity<Skill>(skill,HttpStatus.CREATED);
		}
		else
		{
			return new ResponseEntity<Skill>(skill,HttpStatus.NOT_IMPLEMENTED);
		}
		
	}
	
	@DeleteMapping("/delete/{skillId}")
	public ResponseEntity<Skill> deleteSkill(@PathVariable("skillId") int skillId)
	{
		if(SkillDAOInterface.removeSkill(skillId))
		{
			return new ResponseEntity<Skill>(HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<Skill>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/{skillId}")
	public ResponseEntity<List<Skill>> getSkillById(@PathVariable("skillId") int skillId)
	{
		List<Skill> skillList=SkillDAOInterface.getSkillsById(skillId);
		if(skillList!=null)
		{
			return new ResponseEntity<List<Skill>>(skillList,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<List<Skill>>(skillList,HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/getallskill")
	public ResponseEntity<List<Skill>> getAllSkills()
	{
		List<Skill> allSkills=SkillDAOInterface.getAllSkills();
		if(allSkills!=null)
		{
			return new ResponseEntity<List<Skill>>(allSkills,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<List<Skill>>(HttpStatus.NO_CONTENT);
		}
	}
	

	
	@GetMapping("/skills/{empId}")
	public ResponseEntity<List<Skill>> getAllSkillsByEmployeeId(@PathVariable("empId") int employeeId)
	{
		List<Skill> allSkills=SkillDAOInterface.getAllSkillsOfEmployee(employeeId);
		if(allSkills!=null)
		{
			return new ResponseEntity<List<Skill>>(allSkills,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<List<Skill>>(HttpStatus.NO_CONTENT);
		}
	}
	
}
