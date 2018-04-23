/*package com.niit.skillmapper;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringRunner;

import com.niit.skillmapper.config.HibernateConfiguration;
import com.niit.skillmapper.dao.CertificationDAOInterface;
import com.niit.skillmapper.model.Certification;

import junit.framework.Assert;
@RunWith(SpringRunner.class)
@SpringJUnitConfig(classes = HibernateConfiguration.class)
public class CertificateTestCase {
@Autowired
	CertificationDAOInterface certificationDAOInterface;
	@Test
	public void testAllCertification()
	{
		Certification certificate=new Certification();
		certificate.setCertificationName("OCJP");
		certificate.setEmployeeId(2);
		certificate.setTechnology("Java");
		Assert.assertEquals("Records inserted",true, certificationDAOInterface.addCertification(certificate));
		
	}
	@Test
	public void testDeleteCertification()
	{
		Assert.assertEquals("Records deleted",true, certificationDAOInterface.deleteCertification(2));
	}
	@Test
	public void testUpdateCertification() {
		Certification certificate=new Certification();
		certificate.setCertificationName("WCD");
		certificate.setEmployeeId(2);
		certificate.setTechnology("Java");
		Assert.assertEquals("Records updates",true, certificationDAOInterface.addCertification(certificate));
		
	}
	@Test
	public void testGetCertificateById()
	{
		Assert.assertEquals("Records reterived", certificationDAOInterface.getCertificateById(1));
	}
	@Test
	public void testGetAllCertificates()
	{
		Assert.assertNotNull("Records reterived", certificationDAOInterface.getAllCertificates());
	}
	@Test
	public void testGetCertificatesByEmployeeId()
	{
		Assert.assertNotNull("Records reterived",certificationDAOInterface.getCertificatesByEmployeeId(1));
	}
	@Test
	public void getCertificatesByName()
	{
		Assert.assertNotNull("Records reterived", certificationDAOInterface.getCertificatesByName("OCJP"));
	}


	@Test
	public void testInsert()
	{
		
	}
}
*/