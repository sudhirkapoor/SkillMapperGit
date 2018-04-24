package com.niit.skillmapper.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.niit.skillmapper.dao.EmployeeDAOInterface;
import com.niit.skillmapper.model.Employee;

@RestController
public class LoginValidationController {
	@Autowired
	private EmployeeDAOInterface employeeDAOInterface;

	@PostMapping("/api/authenticate")

	public ResponseEntity<Employee>authenticateEmployee(@RequestBody Employee employee,HttpServletRequest request)
	{
		if(employeeDAOInterface.loginValidate(employee.getEmployeeId(),employee.getPassword()))
		{
			request.getSession().setAttribute("loggedInUser",employeeDAOInterface.getEmployeeById(employee.getEmployeeId()));
			return new ResponseEntity<Employee>(employee,HttpStatus.OK);
		}
		else
		{	
			return new ResponseEntity<Employee>(employee,HttpStatus.UNAUTHORIZED);
		}
	}
	

	@PutMapping("/api/logout")
	public ResponseEntity<HttpStatus> logout(HttpSession session){

		if((Employee)session.getAttribute("loggedInUser")!=null)
		{
			session.removeAttribute("loggedInUser");
			session.invalidate();
			return new ResponseEntity<HttpStatus>(HttpStatus.OK);
		}
		else
			return new ResponseEntity<HttpStatus>(HttpStatus.BAD_REQUEST);

	}

}
	

