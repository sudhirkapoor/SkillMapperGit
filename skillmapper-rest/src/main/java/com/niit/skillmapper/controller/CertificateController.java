package com.niit.skillmapper.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.niit.skillmapper.dao.CertificationDAOInterface;
import com.niit.skillmapper.model.Certification;
import com.niit.skillmapper.model.Employee;

@RestController
@RequestMapping("/api/certificate")
class CertificateController {

	@Autowired
	CertificationDAOInterface certificationDAOInterface;

	@GetMapping("/certificatebyname/{certificateName}")
	public ResponseEntity<Object> getCertificatesByName(@PathVariable("certificateName") String certificateName,
			HttpSession session) {
		List<Certification> certificateList = null;
		if (session.getAttribute("loggedInUser") != null) {
			certificateList = certificationDAOInterface.getCertificatesByName(certificateName);
			if (certificateList == null)
				return new ResponseEntity<Object>("No Employee Found", HttpStatus.NOT_FOUND);
			else {
				certificationDAOInterface.getCertificatesByName(certificateName);
				return new ResponseEntity<Object>("Reterived Certificate by name", HttpStatus.OK);
			}
		} else {
			return new ResponseEntity<Object>("You are Not Authorized, Please login first", HttpStatus.UNAUTHORIZED);
		}
	}


	@PutMapping("/insert")
	public ResponseEntity<Object> insertCertification(@RequestBody Certification certification, HttpSession session) {
		if (session.getAttribute("loggedInUser") != null) {
			if (certification != null) {
				certificationDAOInterface.addCertification(certification);
				return new ResponseEntity<Object>(certification, HttpStatus.OK);
			} else {
				return new ResponseEntity<Object>("Records inserted", HttpStatus.CONFLICT);
			}
		} else {
			return new ResponseEntity<Object>("You are Not Authorized, Please login first", HttpStatus.UNAUTHORIZED);
		}
	}

	@DeleteMapping("/delete/{certificateId}")
	public ResponseEntity<Object> deleteCertificate(@PathVariable("certificateId") int certificateId,
			HttpSession session) {
		if (session.getAttribute("loggedInUser") != null) {
			if (certificateId != 0) {
				certificationDAOInterface.deleteCertification(certificateId);
				return new ResponseEntity<Object>("Certificate is deleted successfully", HttpStatus.OK);
			} else {
				return new ResponseEntity<Object>("Certificate does not exists", HttpStatus.CONFLICT);
			}
		} else {
			return new ResponseEntity<Object>("You are Not Authorized, Please login first", HttpStatus.UNAUTHORIZED);
		}
	}

	@GetMapping("/getallcertificate")
	public ResponseEntity<Object> getAllCertificate(HttpSession session) {

		if (session.getAttribute("loggedInUser") != null) {
			return new ResponseEntity<Object>(certificationDAOInterface.getAllCertificates(), HttpStatus.OK);

		} else {
			return new ResponseEntity<Object>("You are Not Authorized, Please login first", HttpStatus.UNAUTHORIZED);
		}

	}

	@GetMapping("/getcertificatebyempid{employeeId}")
	public ResponseEntity<Object> getCertificationByEmployeeId(@PathVariable("employeeId") int employeeId,
			HttpSession session) {

		List<Certification> certificateList = null;
		if (session.getAttribute("loggedInUser") != null) {
			certificateList = certificationDAOInterface.getCertificatesByEmployeeId(employeeId);
			if (certificateList == null)
				return new ResponseEntity<Object>("No Employee Found", HttpStatus.NOT_FOUND);
			else {
				certificationDAOInterface.getCertificatesByEmployeeId(employeeId);
				return new ResponseEntity<Object>("Certificate reterived", HttpStatus.OK);
			}
		} else {
			return new ResponseEntity<Object>("You are Not Authorized, Please login first", HttpStatus.UNAUTHORIZED);
		}
	}

	@GetMapping("/getcertificatebycertifid{certificationId}")
	public ResponseEntity<Object> getcertificationById(@PathVariable("certificationId") int certificationId,
			HttpSession session) {

		Certification certificate = null;
		if (session.getAttribute("loggedInUser") != null) {
			certificate = certificationDAOInterface.getCertificateById(certificationId);
			if (certificate == null)
				return new ResponseEntity<Object>("No Employee Found", HttpStatus.NOT_FOUND);
			else {
				certificationDAOInterface.getCertificateById(certificationId);
				return new ResponseEntity<Object>("Employee reterived by role", HttpStatus.OK);
			}
		} else {
			return new ResponseEntity<Object>("You are Not Authorized, Please login first", HttpStatus.UNAUTHORIZED);
		}
	}
}
