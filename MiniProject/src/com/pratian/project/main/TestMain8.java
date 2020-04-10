package com.pratian.project.main;

import com.pratian.project.dao.jpa.JpaTrainerDao;
import com.pratian.project.entities.Education;
import com.pratian.project.entities.Trainer;
import com.pratian.project.service.impl.TrainerServiceImpl;

//this test main is to getting the education info
public class TestMain8 
{
	public static void main(String[] args) 
	{
		// Identify test data
		long trainerId = 1;
	
		// Create a Trainer to be searched
		Trainer trainer = new Trainer();
		trainer.setTrainerId(trainerId);

		// Create Trainer service
		TrainerServiceImpl service = new TrainerServiceImpl();

		// Set dao implementation to be used by service
		service.setTrainerDao(new JpaTrainerDao());
		
		//we will get the education info by using trainerid
		Education eduObj = service.viewEducationInfo(trainerId);
		
		// Display education details 
		System.out.println("-----------------------------------------"); 
		System.out.println("Education Id : " + eduObj.getEducationId());
		System.out.println("Institute Name : " + eduObj.getInstituteName());
		System.out.println("Degree : " + eduObj.getDegree()); 
		System.out.println("Specialization : " + eduObj.getSpecialization());
				
		System.out.println("StartYear : " + eduObj.getStartYear());
		System.out.println("EndYear : " + eduObj.getEndYear());
		System.out.println("CourseDuration : " + eduObj.getCourseDuration()); 
		System.out.println("Board : " + eduObj.getBoard());
				
		System.out.println("Percentage : " + eduObj.getPercentage());
		System.out.println("City : " + eduObj.getCity());
		System.out.println("State : " + eduObj.getState()); 
		System.out.println("Country : " + eduObj.getCountry());
		
		System.out.println("-----------------------------------------");
	}

}
