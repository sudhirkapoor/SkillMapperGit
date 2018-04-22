package com.niit.skillmapper.dao.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.skillmapper.dao.SkillDAOInterface;
import com.niit.skillmapper.model.Employees;
import com.niit.skillmapper.model.Skill;

@Repository
@Transactional
public class SkillDAO implements SkillDAOInterface {

	@Autowired
	SessionFactory sessionFactory;
	Skill skill;

	public boolean addSkill(Skill skill) {
		try {
			sessionFactory.getCurrentSession().save(skill);
			this.skill = skill;
			return true;

		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public boolean addEmployeeSkill(int skillId, int employeeId) {
		try {

			/*
			 * preparedStatement =
			 * connection.prepareStatement("insert into EmployeeSkills values(?,?)");
			 * preparedStatement.setInt(1, skill.getSkillId());
			 * preparedStatement.setString(2, skill.getSkillName());
			 * preparedStatement.execute();
			 */
			return true;

		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public List<Employees> getAllEmployeesBySkillName(String skillName) {
		Skill skill = getSkillByName(skillName);
		List<Employees> employees = new ArrayList<Employees>();
		String sql = "select * from Employee e join EmployeeSkills es on e.employeeid=es.employeeid where skillid='"
				+ skill.getSkillId() + "'";
		try {
			/*
			 * stmt = connection.createStatement(); resultSet = stmt.executeQuery(sql);
			 * while (resultSet.next()) { Employees emp = new Employees();
			 * emp.setEmpid(resultSet.getInt("employeeId"));
			 * emp.setEmpname(resultSet.getString("employeeName"));
			 * emp.setEmailid(resultSet.getString("emailId"));
			 * emp.setManagerid(resultSet.getInt("managerId"));
			 * emp.setTtlyearofexp(resultSet.getDouble("totalExperiance"));
			 * emp.setTtlstudenttaught(resultSet.getInt("totalStudentsTaught"));
			 * employees.add(emp); }
			 */
			return employees;
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}

	}

	public List<Skill> getAllSkillsOfEmployee(int employeeId) {
		List<Skill> skills = new ArrayList<Skill>();
		String sql = "select * from Skill s join EmployeeSkills es on s.skillId=es.skillId where employeeId='"
				+ employeeId + "'";
		try {
			/*
			 * stmt = connection.createStatement(); resultSet = stmt.executeQuery(sql);
			 * while (resultSet.next()) { Skill skill = new Skill();
			 * skill.setSkillId(resultSet.getInt("skillId"));
			 * skill.setSkillName(resultSet.getString("skillName")); skills.add(skill); }
			 */
			return skills;
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public boolean removeSkill(Skill skill) {
		try {

			Session session = sessionFactory.getCurrentSession();
			Skill sk = (Skill) session.load(Skill.class, new Integer(skill.getSkillId()));
			session.delete(sk);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;

	}

	public boolean deleteEmployeeSkill(int skillId, int employeeId) {
		// TODO Auto-generated method stub
		return false;
	}

	private Skill getSkillByName(String skillName) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Skill where skillname='" + skillName + "'");
		Skill skill = (Skill) query.getSingleResult();
		if (skill != null) {
			return skill;
		} else {
			return null;
		}
	}
}
