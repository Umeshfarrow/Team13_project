package com.pratian.project.main;

import java.util.List;

import com.pratian.project.dao.jpa.JpaTrainerDao;
import com.pratian.project.entities.Trainer;
import com.pratian.project.service.impl.TrainerServiceImpl;

//TestMain is to get the list of trainers in the trainers Table
public class TestMain5 
{
	public static void main(String[] args)
	{
		// Create Trainer service
		TrainerServiceImpl service = new TrainerServiceImpl();
	
		// Set dao implementation to be used by service
		service.setTrainerDao(new JpaTrainerDao());
		
		// Get all Trainers
		List<Trainer> trainers = service.getAllTrainers();
		
		// Display all trainer details
		System.out.println("----------------------------------------");
		System.out.println("TRAINER DETAILS ARE : ");
		for (Trainer trainer : trainers) {
			System.out.println("------------------------------");
			System.out.println("Trainer Id : " + trainer.getTrainerId());
			System.out.println("Full Name : " + trainer.getFullName());
			System.out.println("Email Id : " + trainer.getEmailId());
			System.out.println("Age : " + trainer.getAge());
			System.out.println("Target :" + trainer.getYearlyTarget());
		}
	}
}
