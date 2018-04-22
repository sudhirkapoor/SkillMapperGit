package com.niit.skillmapper.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotEmpty;

import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name = "Employees")
public class Employees implements Serializable {

	@Id
	@NotEmpty
	private int empid;
	@NotEmpty
	private String empname;
	private double ttlyearofexp;
	private int ttlstudenttaught;
	@NotEmpty
	private int managerid;
	@NotEmpty
	private String password;
	@NotEmpty
	@Column(unique = true)
	private String emailid;
	@NotEmpty
	private String role;
	@NotEmpty
	private String status;
	private String businessunit;
	@NotEmpty
	private String region;
	@NotEmpty
	private String dateofjoining;
	@NotEmpty
	private String department;
	@NotEmpty
	private long contact;
	@NotEmpty
	private String address;
	@NotEmpty
	private String gender;
	@NotEmpty
	private String maritalstatus;
	@NotEmpty
	private String dob;
	@NotEmpty
	private String nationality;
	@NotEmpty
	private String managerName;
	
	
	// Creating getter and setter for the fields

	// Creating parameter Constructor and initializing fields
	/*
	 * public Employee(int empid, String empname, int ttlyearofexp, int
	 * ttlstudenttaught, int managerid, String password, String emailid, String
	 * role, String status,String businessunit,String region,String
	 * dateofjoining,String department) {
	 * 
	 * this.setEmpid(empid); this.setEmpname(empname);
	 * this.setTtlyearofexp(ttlyearofexp);
	 * this.setTtlstudenttaught(ttlstudenttaught); this.setManagerid(managerid);
	 * this.setPassword(password); this.setEmailid(emailid); this.setRole(role);
	 * this.setStatus(status); this.setBusinessunit(businessunit);
	 * this.setRegion(region); this.setDateofjoining(dateofjoining);
	 * this.setBusinessunit(businessunit); }
	 */
	public int getEmpid() {
		return empid;
	}

	public void setEmpid(int empid) {
		this.empid = empid;
	}

	public String getEmpname() {
		return empname;
	}

	public void setEmpname(String empname) {
		this.empname = empname;
	}

	public double getTtlyearofexp() {
		return ttlyearofexp;
	}

	public void setTtlyearofexp(double ttlyearofexp) {
		this.ttlyearofexp = ttlyearofexp;
	}

	public int getTtlstudenttaught() {
		return ttlstudenttaught;
	}

	public void setTtlstudenttaught(int ttlstudenttaught) {
		this.ttlstudenttaught = ttlstudenttaught;
	}

	public int getManagerid() {
		return managerid;
	}

	public void setManagerid(int managerid) {
		this.managerid = managerid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getBusinessunit() {
		return businessunit;
	}

	public void setBusinessunit(String businessunit) {
		this.businessunit = businessunit;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getDateofjoining() {
		return dateofjoining;
	}

	public void setDateofjoining(String dateofjoining) {
		this.dateofjoining = dateofjoining;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public long getContact() {
		return contact;
	}

	public void setContact(long contact) {
		this.contact = contact;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMaritalstatus() {
		return maritalstatus;
	}

	public void setMaritalstatus(String maritalstatus) {
		this.maritalstatus = maritalstatus;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public Employees() {
		// TODO Auto-generated constructor stub
	}

}
