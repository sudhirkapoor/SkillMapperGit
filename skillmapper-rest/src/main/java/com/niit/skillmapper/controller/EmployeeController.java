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
			
			return new ResponseEntity<Object>(employeeDAOInterface.getEmployeeById(employeeId), HttpStatus.OK);
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
				
				return new ResponseEntity<Object>(employeeDAOInterface.getEmployeeByRegion(region), HttpStatus.OK);
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
				
				return new ResponseEntity<Object>(employeeDAOInterface.getEmployeeByLocation(location), HttpStatus.OK);
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
					return new ResponseEntity<Object>(employeeDAOInterface.getEmployeeByLocation(department), HttpStatus.OK);
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
					return new ResponseEntity<Object>(employeeDAOInterface.getEmployeeByRole(role), HttpStatus.OK);
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
				
				return new ResponseEntity<Object>(employeeDAOInterface.updateEmployee(employee), HttpStatus.OK);
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
				
				return new ResponseEntity<Object>(employeeDAOInterface.approveEmployeeByHR(employeeId) , HttpStatus.OK);
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
				
				return new ResponseEntity<Object>(employeeDAOInterface.insertEmployee(employee), HttpStatus.OK);
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
								
					return new ResponseEntity<Object>(employeeDAOInterface.deleteEmployee(employeeId), HttpStatus.OK);
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

 	@GetMapping("/skillname/{skillname}")
	public ResponseEntity<Object> getAllEmployeesByMultipleSkillName(@PathVariable("skillname") String skillname, HttpSession session) {
	 		List<Employee> employeeList=null;
	 		if (session.getAttribute("loggedInUser") != null) {
			employeeList = employeeDAOInterface.getAllEmployeesByMultipleSkillName(skillname);
			for (Employee employee : employeeList) {
				System.out.println(employee.getEmployeeName());
			}
			if (employeeList == null)
				return new ResponseEntity<Object>("No Employee Found", HttpStatus.NOT_FOUND);
			else {
				return new ResponseEntity<Object>(employeeDAOInterface.getAllEmployeesByMultipleSkillName(skillname), HttpStatus.OK);
			}
		} else {
			return new ResponseEntity<Object>("You are Not Authorized, Please login first", HttpStatus.UNAUTHORIZED);
		}
	}
	
	
	
}
	