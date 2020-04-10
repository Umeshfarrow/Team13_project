package com.pratian.project.main;

import com.pratian.project.dao.jpa.JpaTrainerDao;
import com.pratian.project.entities.Education;
import com.pratian.project.entities.Trainer;
import com.pratian.project.service.impl.TrainerServiceImpl;

public class TestMain7 
{
	public static void main(String[] args) 
	{
		// setting the data of the Education
		long educationId = 3;
		String instituteName = "Anna University";
		String degree = "B-Tech";
		String specialization = "CSE";
		int startYear = 2015;
		int endYear = 2019;
		int courseDuration = 4;
		String board = "JNTU"; // board of institution
		int percentage = 70;
		String city = "Nellore";
		String state = "AndhraPradesh";
		String country = "India";

		//create the education
		Education education = new Education(instituteName, degree, specialization, startYear, endYear, courseDuration,
				board, percentage, city, state, country);
		
		//setting the education to the educationID
		education.setEducationId(educationId);
		
		long trainerId = 1;
		Trainer trainer = new Trainer();
		trainer.setTrainerId(trainerId);
		
		// Create Trainer service
		TrainerServiceImpl service = new TrainerServiceImpl();
		
		// Set dao implementation to be used by service
		service.setTrainerDao(new JpaTrainerDao());
		
		boolean status =  service.editEducationInfo(education);
		
		// Display update Education status
		String message1 = "Updated successfully ";
		String message2 = "Something went wrong!!! \n Not updated";
		System.out.println(status ? message1 : message2);

	}

}
