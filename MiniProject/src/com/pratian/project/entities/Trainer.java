package com.pratian.project.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Trainer
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long trainerId;
	private String fullName;
	private String emailId;
	private float yearlyTarget;
	private int age;
	
	//it is used to map the relation between trainer and Education
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "educationId")
	private Education education; // one trainer has one education

	public Trainer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Trainer(String fullName, String emailId, float yearlyTarget, int age) {
		super();
		this.fullName = fullName;
		this.emailId = emailId;
		this.yearlyTarget = yearlyTarget;
		this.age = age;
	}

	public long getTrainerId() {
		return trainerId;
	}

	public void setTrainerId(long trainerId) {
		this.trainerId = trainerId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public float getYearlyTarget() {
		return yearlyTarget;
	}

	public void setYearlyTarget(float yearlyTarget) {
		this.yearlyTarget = yearlyTarget;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Education getEducation() {
		return education;
	}

	public void setEducation(Education education) {
		this.education = education;
	}

	@Override
	public String toString() {
		return "Trainer [trainerId=" + trainerId + ", fullName=" + fullName + ", emailId=" + emailId + ", yearlyTarget="
				+ yearlyTarget + ", age=" + age + "]";
	}
}
