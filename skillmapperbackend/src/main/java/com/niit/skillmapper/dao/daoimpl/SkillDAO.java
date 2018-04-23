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
import com.niit.skillmapper.model.Employee;
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

	

	

	public List<Skill> getAllSkillsOfEmployee(int employeeId) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Skill where employeeId='" + employeeId + "'");
		List<Skill> skillList= query.getResultList();
		if (skillList != null) {
			return skillList;
		} else {
			return null;
		}
	}

	public boolean removeSkill(int skillId) {
		try {

			Session session = sessionFactory.getCurrentSession();
			Skill sk = (Skill) session.load(Skill.class, skillId);
			session.delete(sk);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;

	}





	@Override
	public boolean updateSkill(Skill skill) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().update(skill);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return false;
	}





	@Override
	public List<Skill> getSkillsById(int skillId) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Skill where skillId='" + skillId + "'");
		List<Skill> skillList= query.getResultList();
		if (skillList != null) {
			return skillList;
		} else {
			return null;
		}
	}





	@Override
	public List<Skill> getAllSkills() {
		Query query = sessionFactory.getCurrentSession().createQuery("from Skill");

		List<Skill> skillList = query.getResultList();
		
		return skillList;
	}

	
}
