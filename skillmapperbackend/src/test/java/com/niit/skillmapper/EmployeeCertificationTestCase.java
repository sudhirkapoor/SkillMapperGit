package com.niit.skillmapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringRunner;

import com.niit.skillmapper.config.HibernateConfiguration;
import com.niit.skillmapper.dao.EmployeeCertificationInterface;
import com.niit.skillmapper.model.EmployeeCertification;

import junit.framework.Assert;
@RunWith(SpringRunner.class)
@SpringJUnitConfig(classes = HibernateConfiguration.class)
public class EmployeeCertificationTestCase {
	@Autowired
	EmployeeCertificationInterface employeeCertificationInterface;

	@Test
	public void testInsertEmployeeCertification() {
		EmployeeCertification employeeCertification = new EmployeeCertification();
		employeeCertification.setCertificationName("OCJP");
		employeeCertification.setEmpId(1);
		employeeCertification.setTechnology(".NET");
		org.junit.Assert.assertEquals("Certificate details added", true,
				employeeCertificationInterface.insertEmployeeCertification(employeeCertification));
	}

}
