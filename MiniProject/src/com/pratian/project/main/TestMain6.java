package com.pratian.project.main;

import com.pratian.project.entities.Education;
import com.pratian.project.entities.Trainer;
import com.pratian.project.service.impl.TrainerServiceImpl;

//this testmain is to add education to the DB
public class TestMain6 
{
	public static void main(String[] args) 
	{
		//setting the data of the Education
		String instituteName = "Kalasalingam University";
		String degree = "B-Tech";
		String specialization = "ECE";
		int startYear = 2015;
		int endYear = 2019;
		int courseDuration = 4;
		String board = "Deemed University"; //board of institution
		int percentage = 60;
		String city = "Madurai";
		String state = "TamilNadu";
		String country = "India";
		
		//create the trainer
		Trainer trainer = new Trainer();
		long trainerId = 1; 
		trainer.setTrainerId(trainerId);
		
		//create the education
		Education education = new Education(instituteName, degree, specialization, startYear, endYear, 
								courseDuration, board, percentage, city, state, country);
		
		//setting the education to the trainer 
		trainer.setEducation(education);
		
		// Create Trainer service
		TrainerServiceImpl service = new TrainerServiceImpl();
		
		//getting the details of the trainerID
		Trainer trainerObj = service.getTrainerByTrainerId(trainerId);
		
		//add the trainerObj and education 
		boolean status = service.addTrainersEducationInfo(trainerObj, education);

		// Display storing Education status
		String message1 = "Saved successfully ";
		String message2 = "Something went wrong!!! \n Try Again";
		System.out.println(status ? message1 : message2);
		
	}

}
