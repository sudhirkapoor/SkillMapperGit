package com.niit.skillmapper.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Employee implements Serializable{

	/**
	 * 
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int employeeId;
	private String emailId;
	private String password;
	private String employeeName;
	private String department;
	private String location;
	private double totalYearsOfExp;
	private int totalStudentsTaught;
	private String status = "inactive";
	private int managerId;
	private String dateOfJoining;
	private String region;
	private String businessUnit;
	private String role;
	private String interClassDetail;
	private String higherSchool;
	private String graduation;
	private String gender;
	private String contactNumber;
	private String projectUnderTaken;
	
	
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public double getTotalYearsOfExp() {
		return totalYearsOfExp;
	}
	public void setTotalYearsOfExp(double totalYearsOfExp) {
		this.totalYearsOfExp = totalYearsOfExp;
	}
	public int getTotalStudentsTaught() {
		return totalStudentsTaught;
	}
	public void setTotalStudentsTaught(int totalStudentsTaught) {
		this.totalStudentsTaught = totalStudentsTaught;
	}
	public String isStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getManagerId() {
		return managerId;
	}
	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}
	public String getDateOfJoining() {
		return dateOfJoining;
	}
	public void setDateOfJoining(String dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getBusinessUnit() {
		return businessUnit;
	}
	public void setBusinessUnit(String businessUnit) {
		this.businessUnit = businessUnit;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getInterClassDetail() {
		return interClassDetail;
	}
	public void setInterClassDetail(String interClassDetail) {
		this.interClassDetail = interClassDetail;
	}
	public String getHigherSchool() {
		return higherSchool;
	}
	public void setHigherSchool(String higherSchool) {
		this.higherSchool = higherSchool;
	}
	public String getGraduation() {
		return graduation;
	}
	public void setGraduation(String graduation) {
		this.graduation = graduation;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getProjectUnderTaken() {
		return projectUnderTaken;
	}
	public void setProjectUnderTaken(String projectUnderTaken) {
		this.projectUnderTaken = projectUnderTaken;
	}
	public String getStatus() {
		return status;
	}
	
	
}
