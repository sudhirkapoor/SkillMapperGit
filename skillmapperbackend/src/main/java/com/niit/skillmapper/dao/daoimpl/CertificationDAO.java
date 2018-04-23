package com.niit.skillmapper.dao.daoimpl;

import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import javax.transaction.Transactional;

import org.hibernate.*;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.skillmapper.dao.CertificationDAOInterface;
import com.niit.skillmapper.model.Certification;
import com.niit.skillmapper.model.Employee;


@Repository
@Transactional
public class CertificationDAO implements CertificationDAOInterface{

	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public boolean addCertification(Certification certification) {
		try {
			sessionFactory.getCurrentSession().save(certification);
			return true;
		} 
		catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deleteCertification(int certificateId) {
		try {
			sessionFactory.getCurrentSession().delete(getCertificateById(certificateId));
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateCertification(Certification certification) {
		try {
			sessionFactory.getCurrentSession().update(certification);
			return true;
		} 
		catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public Certification getCertificateById(int certificationId) {
		try
		{
			return sessionFactory.getCurrentSession().get(Certification.class, certificationId);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Certification> getAllCertificates() {
		try
		{
			return sessionFactory.getCurrentSession().createQuery("FROM Certification").list();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Certification> getCertificatesByEmployeeId(int empId) {
		try
		{
			Query query = sessionFactory.getCurrentSession().createQuery("from Certification where empId=:empId");
			query.setInteger("empId", empId);
			List<Certification> list = query.list();
			return list;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Certification> getCertificatesByName(String certificationName) {
		try
		{
			Query query = sessionFactory.getCurrentSession().createQuery("from Certification where certificationName=:certificationName");
			query.setString("certificationName", certificationName);
			List<Certification> list = query.list();
			return list;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return null;
		}
	}

}
