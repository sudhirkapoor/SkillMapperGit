package com.niit.skillmapper.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class EmployeeSkills implements Serializable {

	/**
	 * 
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int skillId;
	private int empid;
	private int rating;
	private String graduation;
	private String masters;
	private String inter;
	private String higher;
	private String projectundertaken;
	private String os;
	private String programingLanguage;
	private String database;
	private String framework;
	private String testingtool;
	private String buildtool;

	public int getEmpid() {
		return empid;
	}

	public void setEmpid(int empid) {
		this.empid = empid;
	}

	public int getSkillId() {
		return skillId;
	}

	public void setSkillId(int skillId) {
		this.skillId = skillId;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getGraduation() {
		return graduation;
	}

	public void setGraduation(String graduation) {
		this.graduation = graduation;
	}

	public String getMasters() {
		return masters;
	}

	public void setMasters(String masters) {
		this.masters = masters;
	}

	public String getInter() {
		return inter;
	}

	public void setInter(String inter) {
		this.inter = inter;
	}

	public String getHigher() {
		return higher;
	}

	public void setHigher(String higher) {
		this.higher = higher;
	}

	public String getProjectundertaken() {
		return projectundertaken;
	}

	public void setProjectundertaken(String projectundertaken) {
		this.projectundertaken = projectundertaken;
	}

	public String getOs() {
		return os;
	}

	public void setOs(String os) {
		this.os = os;
	}

	public String getProgramingLanguage() {
		return programingLanguage;
	}

	public void setProgramingLanguage(String programingLanguage) {
		this.programingLanguage = programingLanguage;
	}

	public String getDatabase() {
		return database;
	}

	public void setDatabase(String database) {
		this.database = database;
	}

	public String getFramework() {
		return framework;
	}

	public void setFramework(String framework) {
		this.framework = framework;
	}

	public String getTestingtool() {
		return testingtool;
	}

	public void setTestingtool(String testingtool) {
		this.testingtool = testingtool;
	}

	public String getBuildtool() {
		return buildtool;
	}

	public void setBuildtool(String buildtool) {
		this.buildtool = buildtool;
	}

}
