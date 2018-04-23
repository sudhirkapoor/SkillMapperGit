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
import com.niit.skillmapper.model.Employee;

@RestController
@RequestMapping("/api/certificate")
class CertificateController {

	@Autowired
	CertificationDAOInterface certificationDAOInterface;

	@GetMapping("//{role}")
	public ResponseEntity<Object> getEmployeeByRole(@PathVariable("role") String role, HttpSession session) {
		List<Employee> employeeList = null;
		if (session.getAttribute("loggedInUser") != null) {
			employeeList = employeeDAOInterface.getEmployeeByRole(role);
			if (employeeList == null)
				return new ResponseEntity<Object>("No Employee Found", HttpStatus.NOT_FOUND);
			else {
				employeeDAOInterface.getEmployeeByRole(role);
				return new ResponseEntity<Object>("Employee reterived by role", HttpStatus.OK);
			}
		} else {
			return new ResponseEntity<Object>("You are Not Authorized, Please login first", HttpStatus.UNAUTHORIZED);
		}
	}

	@PutMapping("/update")
	public ResponseEntity<Object> updateEmployee(@RequestBody Employee employee, HttpSession session) {
		if (session.getAttribute("loggedInUser") != null) {
			if (certificationDAOInterface.getEmployeeById(employee.getEmployeeId()) != null) {
				employeeDAOInterface.updateEmployee(employee);
				return new ResponseEntity<Object>(employee, HttpStatus.OK);
			} else {
				return new ResponseEntity<Object>("Employee does not exists", HttpStatus.CONFLICT);
			}
		} else {
			return new ResponseEntity<Object>("You are Not Authorized, Please login first", HttpStatus.UNAUTHORIZED);
		}
	}

	@PutMapping("/insert")
	public ResponseEntity<Object> insertEmployee(@RequestBody Employee employee, HttpSession session) {
		if (session.getAttribute("loggedInUser") != null) {
			if (employee != null) {
				employeeDAOInterface.insertEmployee(employee);
				return new ResponseEntity<Object>(employee, HttpStatus.OK);
			} else {
				return new ResponseEntity<Object>("Employee does not exists", HttpStatus.CONFLICT);
			}
		} else {
			return new ResponseEntity<Object>("You are Not Authorized, Please login first", HttpStatus.UNAUTHORIZED);
		}
	}

	@DeleteMapping("/delete/{employeeId}")
	public ResponseEntity<Object> deleteEmployee(@PathVariable("employeeId") int employeeId, HttpSession session) {
		if (session.getAttribute("loggedInUser") != null) {
			if (employeeDAOInterface.getEmployeeById(employeeId) != null) {
				employeeDAOInterface.deleteEmployee(employeeId);
				return new ResponseEntity<Object>("Employee is deleted successfully", HttpStatus.OK);
			} else {
				return new ResponseEntity<Object>("Employee does not exists", HttpStatus.NOT_FOUND);
			}
		} else {
			return new ResponseEntity<Object>("You are Not Authorized, Please login first", HttpStatus.UNAUTHORIZED);
		}
	}

	@GetMapping("/getallemployee")
	public ResponseEntity<List<Employee>> getAllEmployee() {
		return new ResponseEntity<List<Employee>>(employeeDAOInterface.getAllEmployee(), HttpStatus.OK);
	}

	@GetMapping("/{employeeId}")
	public ResponseEntity<Object> getEmployeeById(@PathVariable("employeeId") int employeeId, HttpSession session) {

		Employee employee = employeeDAOInterface.getEmployeeById(employeeId);
		if (employee == null)
			return new ResponseEntity<Object>("No User Found", HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<Object>(employee, HttpStatus.OK);
	}

}
