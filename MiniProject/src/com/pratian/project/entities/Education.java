package com.pratian.project.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Education 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long educationId;
	private String instituteName;
	
	private String degree;
	private String specialization;
	private int startYear;
	private int endYear;
	private int courseDuration;
	private String board; //board of institution
	private int percentage;
	private String city;
	private String state;
	private String country;
	
	//default constructor
	public Education() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	//parametrized constructor
	public Education(String instituteName, String degree, String specialization, int startYear, int endYear, int courseDuration, String board,
			int percentage, String city, String state, String country) {
		super();
		this.instituteName = instituteName;
		this.degree = degree;
		this.specialization = specialization;
		this.startYear = startYear;
		this.endYear = endYear;
		this.courseDuration = courseDuration;
		this.board = board;
		this.percentage = percentage;
		this.city = city;
		this.state = state;
		this.country = country;
	}
	
	//setter and getters
	public long getEducationId() {
		return educationId;
	}

	public void setEducationId(long educationId) {
		this.educationId = educationId;
	}
	
	public String getInstituteName() {
		return instituteName;
	}
	public void setInstituteName(String instituteName) {
		this.instituteName = instituteName;
	}
	public String getDegree() {
		return degree;
	}
	public void setDegree(String degree) {
		this.degree = degree;
	}
	public String getSpecialization() {
		return specialization;
	}
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	public int getStartYear() {
		return startYear;
	}
	public void setStartYear(int startYear) {
		this.startYear = startYear;
	}
	public int getEndYear() {
		return endYear;
	}
	public void setEndYear(int endYear) {
		this.endYear = endYear;
	}
	public int getCourseDuration() {
		return courseDuration;
	}
	public void setCourseDuration(int courseDuration) {
		this.courseDuration = courseDuration;
	}
	public String getBoard() {
		return board;
	}
	public void setBoard(String board) {
		this.board = board;
	}
	public int getPercentage() {
		return percentage;
	}
	public void setPercentage(int percentage) {
		this.percentage = percentage;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
}
