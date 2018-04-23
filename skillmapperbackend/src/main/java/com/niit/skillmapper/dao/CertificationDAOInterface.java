package com.niit.skillmapper.dao;

import java.util.List;

import com.niit.skillmapper.model.Certification;
import com.niit.skillmapper.model.Employee;

public interface CertificationDAOInterface {
	boolean addCertification(Certification certification);
	boolean deleteCertification(int certificateId);
	boolean updateCertification(Certification certification);
	Certification getCertificateById(int certificationId);
	List<Certification> getAllCertificates();
	List<Certification> getCertificatesByEmployeeId(int employeeId);
	List<Certification> getCertificatesByName(String certificationName);

}
