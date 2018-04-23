package com.niit.skillmapper.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.niit.skillmapper.dao.EmployeeDAOInterface;
import com.niit.skillmapper.model.*;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

	@Autowired
	EmployeeDAOInterface employeeDAOInterface;

	

	@GetMapping("/")
	public String home() {
		System.out.println("heheheheh");
		return "index";
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

	@GetMapping("/businessUnit/{businessUnit}")
	public ResponseEntity<Object>  getEmployeeByManagerId(@PathVariable("businessUnit") String businessUnit,
			HttpSession session) {
		List<Employee> employeeList = null;
		if (session.getAttribute("loggedInUser") != null) {
			employeeList = employeeDAOInterface.getEmployeeByBusinessUnit(businessUnit);
			if (employeeList == null)
				return new ResponseEntity<Object> ("Employee does not exists", HttpStatus.NOT_FOUND);
			else {
				employeeList = employeeDAOInterface.getEmployeeByBusinessUnit(businessUnit);
				return new ResponseEntity<Object> (employeeList, HttpStatus.OK);
			}
		} else {
			return new ResponseEntity<Object>("You are Not Authorized, Please login first", HttpStatus.UNAUTHORIZED);
		}
	}
	
	@GetMapping("/region/{region}")
	public ResponseEntity<Object> getEmployeeByRegion(@PathVariable("region") String region, HttpSession session) {
		List<Employee> employeeList = null;
		if (session.getAttribute("loggedInUser") != null) {
			employeeList = employeeDAOInterface.getEmployeeByRegion(region);
			if (employeeList == null)
				return new ResponseEntity<Object>("No Employee Found", HttpStatus.NOT_FOUND);
			else {
		;
				return new ResponseEntity<Object>("Employee reterived by department", HttpStatus.OK);
			}
		} else {
			return new ResponseEntity<Object>("You are Not Authorized, Please login first", HttpStatus.UNAUTHORIZED);
		}
	}
	 	@GetMapping("/location/{location}")
	public ResponseEntity<Object> getEmployeeByLocation(@PathVariable("location") String location, HttpSession session) {
	 		List<Employee> employeeList=null;
	 		if (session.getAttribute("loggedInUser") != null) {
			employeeList = employeeDAOInterface.getEmployeeByLocation(location);
			if (employeeList == null)
				return new ResponseEntity<Object>("No Employee Found", HttpStatus.NOT_FOUND);
			else {
				employeeDAOInterface.getEmployeeByLocation(location);
				return new ResponseEntity<Object>("Employee reterived by location", HttpStatus.OK);
			}
		} else {
			return new ResponseEntity<Object>("You are Not Authorized, Please login first", HttpStatus.UNAUTHORIZED);
		}
	}
	 	
	 	
	 	@GetMapping("/department/{department}")
		public ResponseEntity<Object> getEmployeeByDepartment(@PathVariable("department") String department, HttpSession session) {
		 		List<Employee> employeeList=null;
		 		if (session.getAttribute("loggedInUser") != null) {
				employeeList = employeeDAOInterface.getEmployeeByDepartment(department);
				if (employeeList == null)
					return new ResponseEntity<Object>("No Employee Found", HttpStatus.NOT_FOUND);
				else {
					employeeDAOInterface.getEmployeeByLocation(department);
					return new ResponseEntity<Object>("Employee reterived by department", HttpStatus.OK);
				}
			} else {
				return new ResponseEntity<Object>("You are Not Authorized, Please login first", HttpStatus.UNAUTHORIZED);
			}
		}
	 	
	 	
	 	@GetMapping("/role/{role}")
		public ResponseEntity<Object> getEmployeeByRole(@PathVariable("role") String role, HttpSession session) {
		 		List<Employee> employeeList=null;
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
	public ResponseEntity<Object> updateEmployee(@RequestBody Employee employee,
			HttpSession session) {
		if (session.getAttribute("loggedInUser") != null) {
			if (employeeDAOInterface.getEmployeeById(employee.getEmployeeId()) != null) {
				employeeDAOInterface.updateEmployee(employee);
				return new ResponseEntity<Object>(employee, HttpStatus.OK);
			} else {
				return new ResponseEntity<Object>("Employee does not exists", HttpStatus.CONFLICT);
			}
		} else {
			return new ResponseEntity<Object>("You are Not Authorized, Please login first", HttpStatus.UNAUTHORIZED);
		}
	}
	
	@PutMapping("/approveemployee/{employeeId}")
	public ResponseEntity<Object>approveEmployeeByHR(@PathVariable("employeeId") int employeeId,HttpSession session)
	{
		if(session.getAttribute("loggedInUser")!=null)
		{
			if(employeeDAOInterface.getEmployeeById(employeeId)!=null)
			{
				employeeDAOInterface.approveEmployeeByHR(employeeId);			
				return new ResponseEntity<Object>("Employee is deleted successfully" , HttpStatus.OK);
			}
			else
			{
				return new ResponseEntity<Object>("Employee does not exists", HttpStatus.NOT_FOUND);
			}
		}
		else
		{
			return new ResponseEntity<Object>("You are Not Authorized, Please login first" , HttpStatus.UNAUTHORIZED);
		}
	}
	@PutMapping("/insert")
	public ResponseEntity<Object> insertEmployee(@RequestBody Employee employee,HttpSession session) {
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
		public ResponseEntity<Object>deleteEmployee(@PathVariable("employeeId") int employeeId,HttpSession session)
		{
			if(session.getAttribute("loggedInUser")!=null)
			{
				if(employeeDAOInterface.getEmployeeById(employeeId)!=null)
				{
					employeeDAOInterface.deleteEmployee(employeeId);			
					return new ResponseEntity<Object>("Employee is deleted successfully" , HttpStatus.OK);
				}
				else
				{
					return new ResponseEntity<Object>("Employee does not exists", HttpStatus.NOT_FOUND);
				}
			}
			else
			{
				return new ResponseEntity<Object>("You are Not Authorized, Please login first" , HttpStatus.UNAUTHORIZED);
			}
		}

}
	