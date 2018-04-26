package com.niit.skillmapper.dao.daoimpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.skillmapper.dao.SkillDAOInterface;
import com.niit.skillmapper.model.Skill;

@Repository
@Transactional
public class SkillDAO implements SkillDAOInterface {

	@Autowired
	SessionFactory sessionFactory;
	Skill skill=null;

	public List<Skill> getAllSkillsOfEmployee(int employeeId) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Skill where employeeId='" + employeeId + "'");
		List<Skill> skillList = query.getResultList();
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


	public List<Skill> getSkillsById(int skillId) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Skill where skillId='" + skillId + "'");
		List<Skill> skillList = query.getResultList();
		if (skillList != null) {
			return skillList;
		} else {
			return null;
		}
	}

	
	public List<Skill> getAllSkills() {
		Query query = sessionFactory.getCurrentSession().createQuery("from Skill");

		List<Skill> skillList = query.getResultList();

		return skillList;
	}


	public boolean addSkill(Skill skill) {
		try {
			List<Skill> list = new ArrayList<Skill>();
			String skillNames[] = skill.getSkillName().split(",");
			for (String sklname : skillNames) {
				if (skill != null) {
					String skillname[] = sklname.trim().split(" ");
					for (String s : skillname) {
						if (!(s.equals("and") || s.equals("or") || s.equals("the"))) {
							Skill newSkill = new Skill();
							newSkill.setSkillName(s);
							newSkill.setEmployeeId(skill.getEmployeeId());
							newSkill.setNumberOfHoursTought(skill.getNumberOfHoursTought());
							newSkill.setTotalYearsOfExperiance(skill.getTotalYearsOfExperiance());
							newSkill.setRating(skill.getRating());
							list.add(newSkill);
						}
					}
				}
			}
			for (Skill newskill : list)
				sessionFactory.getCurrentSession().save(newskill);

			return true;
		} catch (HibernateException exception) {
			return false;
		}
	}


	public boolean updateSkill(Skill skill) {
		try {
			sessionFactory.getCurrentSession().update(skill);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		}

		return false;
	}

}
