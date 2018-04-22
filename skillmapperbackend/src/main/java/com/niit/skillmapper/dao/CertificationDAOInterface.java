package com.niit.skillmapper.dao;

import java.util.List;

import com.niit.skillmapper.model.Certification;
import com.niit.skillmapper.model.Employees;

public interface CertificationDAOInterface {
	boolean addCertification(Certification certification);
	List<Employees> getAllEmployeesByCertificationName(String certificationName);
	List<Certification> getCertificationByEmployeeId(int employeeId);
	boolean deleteCertification(int employeeId,int certificationId);

}
