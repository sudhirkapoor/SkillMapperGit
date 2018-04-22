package com.niit.skillmapper.dao.daoimpl;

import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.skillmapper.dao.EmployeeCertificationInterface;
import com.niit.skillmapper.model.EmployeeCertification;
import com.niit.skillmapper.model.EmployeeSkills;
@Repository
@Transactional
public class EmployeeCertificationDAO implements EmployeeCertificationInterface {

	@Autowired
	SessionFactory sessionFactory;
	public boolean insertEmployeeCertification(EmployeeCertification employeeCertification) {
		
		try {
			sessionFactory.getCurrentSession().save(employeeCertification);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean updateEmployeeCertification(EmployeeCertification employeeCertification) {
		try {
			sessionFactory.getCurrentSession().update(employeeCertification);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public List<EmployeeCertification> getAllEmployeeCertification() {
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from EmployeeCertification ");
		List<EmployeeCertification> employeeCertificationList=query.getResultList();
		if (employeeCertificationList!=null) {
			return employeeCertificationList;
		} else {
			return null;
		}
	}

	public List<EmployeeCertification> getEmployeeEmployeeCertificationByEmpId(int empId) {
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from EmployeeCertification where empId='"+empId+"'");
		List<EmployeeCertification> employeeCertificationList=query.getResultList();
		if (employeeCertificationList!=null) {
			return employeeCertificationList;
		} else {
			return null;
		}
	}

	public List<EmployeeCertification> getEmployeeCertificationByCertificateName(String certificateName) {
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from EmployeeCertification where certificatename='"+certificateName+"'");
		List<EmployeeCertification> employeeCertificationList=query.getResultList();
		if (employeeCertificationList!=null) {
			return employeeCertificationList;
		} else {
			return null;
		}
	}

	public List<EmployeeCertification> getEmployeeCertificationByTechnologyName(String technologyName) {
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from EmployeeCertification where technologyName='"+technologyName+"'");
		List<EmployeeCertification> employeeCertificationList=query.getResultList();
		if (employeeCertificationList!=null) {
			return employeeCertificationList;
		} else {
			return null;
		}
	}

}
