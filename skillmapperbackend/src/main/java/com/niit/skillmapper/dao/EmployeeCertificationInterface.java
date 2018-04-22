package com.niit.skillmapper.dao;

import java.util.List;

import com.niit.skillmapper.model.EmployeeCertification;
import com.niit.skillmapper.model.EmployeeSkills;

public interface EmployeeCertificationInterface {
	public boolean insertEmployeeCertification(EmployeeCertification employeeCertification);
	public boolean updateEmployeeCertification(EmployeeCertification employeeCertification);
	public List<EmployeeCertification> getAllEmployeeCertification();
	public List<EmployeeCertification> getEmployeeEmployeeCertificationByEmpId(int empId);
	public List<EmployeeCertification> getEmployeeCertificationByCertificateName(String certificateName);
	public List<EmployeeCertification> getEmployeeCertificationByTechnologyName(String technologyName);
}
