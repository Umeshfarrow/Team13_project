package com.pratian.project.main;

import com.pratian.project.dao.jpa.JpaTrainerDao;
import com.pratian.project.entities.Trainer;
import com.pratian.project.service.impl.TrainerServiceImpl;

//this test main is to update the trainer details
public class TestMain2
{
	public static void main(String[] args) 
	{
		// Identify test data to update the trainer
		long trainerId = 1;
		String fullName = "Chandra";
		String emailId = "chandrashekhar@pratian.com";
		float target = 15_00_000.0f;
		int age = 26;
	
		// Create a Trainer to update the details
		Trainer trainer = new Trainer(fullName, emailId, target, age);
		trainer.setTrainerId(trainerId);
		
		// Create Trainer service
		TrainerServiceImpl service = new TrainerServiceImpl();
		
		// Set dao implementation to be used by service
		service.setTrainerDao(new JpaTrainerDao());
		
		// Update Trainer
		boolean status = service.editTrainer(trainer);
		
		// Display update trainer status
		String message1 = "Updated successfully ";
		String message2 = "Something went wrong!!! \n Not updated";
		System.out.println(status ? message1 : message2);

	}

}
