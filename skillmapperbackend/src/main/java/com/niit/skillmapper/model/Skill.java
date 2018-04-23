package com.niit.skillmapper.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Skill implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int skillId;
	private int employeeId;
	private String skillName;
	private double numberOfHoursTought;
	private double totalYearsOfExperiance;
	private double rating;
	public int getSkillId() {
		return skillId;
	}
	public void setSkillId(int skillId) {
		this.skillId = skillId;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getSkillName() {
		return skillName;
	}
	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}
	public double getNumberOfHoursTought() {
		return numberOfHoursTought;
	}
	public void setNumberOfHoursTought(double numberOfHoursTought) {
		this.numberOfHoursTought = numberOfHoursTought;
	}
	public double getTotalYearsOfExperiance() {
		return totalYearsOfExperiance;
	}
	public void setTotalYearsOfExperiance(double totalYearsOfExperiance) {
		this.totalYearsOfExperiance = totalYearsOfExperiance;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	
	
}
