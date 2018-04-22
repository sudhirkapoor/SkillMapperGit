package com.niit.skillmapper.dao.daoimpl;

import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.skillmapper.dao.CertificationDAOInterface;
import com.niit.skillmapper.model.Certification;
import com.niit.skillmapper.model.EmployeeCertification;
import com.niit.skillmapper.model.Employees;


@Repository
@Transactional
public class CertificationDAO implements CertificationDAOInterface{

	@Autowired
	private SessionFactory sessionFactory;
	

	
	public boolean addCertification(Certification certification) {
		try
		{
			sessionFactory.getCurrentSession().save(certification);
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
	}

	public List<Employees> getAllEmployeesByCertificationName(String certificationName) {
		List<Employees> employeeList=null;
		List<Certification> certificateList=new ArrayList<Certification>(); 
		List<EmployeeCertification> employeeCertificateList=new ArrayList<EmployeeCertification>();
		String hql = "select p from Conn c   inner join c.Patient  p  inner join c.Bill b  where b.Balance < :balance and p.FullName = 'John' ";
		try {

			Session session = sessionFactory.getCurrentSession();
			Query query=session.createQuery("from certification where empname='"+certificationName+"'");
			certificateList=query.getResultList();
			for (Certification certificate : certificateList) {
				EmployeeCertification empcertif = (EmployeeCertification) session.load(EmployeeCertification.class, new Integer(certificate.getCertificationId()));
				employeeCertificateList.add(empcertif);
				
			}
			
			for (EmployeeCertification employeeCertificate : employeeCertificateList) {
				Employees emp = (Employees) session.load(Employees.class, new Integer(employeeCertificate.getEmpId()));
				employeeList.add(emp);
				
			}
			return employeeList;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return employeeList;
	
	}

	
	public List<Certification> getCertificationByEmployeeId(int employeeId) {
		List<Certification> certificateList=null;
		try {

			Session session = sessionFactory.getCurrentSession();
			Query query=session.createQuery("from certification where empid='"+employeeId+"'");
			certificateList =query.getResultList();
			
			return certificateList;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return certificateList;
	}

	
	public boolean deleteCertification(int employeeId, int certificationId) {
		// TODO Auto-generated method stub
		return false;
	}

}
