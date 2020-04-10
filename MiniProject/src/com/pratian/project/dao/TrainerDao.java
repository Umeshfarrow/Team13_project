package com.pratian.project.dao;

import java.util.List;

import com.pratian.project.entities.Education;
import com.pratian.project.entities.Trainer;

public interface TrainerDao
{
	//this is for adding the trainer details......
	public long saveTrainer(Trainer trainer);
	public boolean updateTrainer(Trainer trainer);
	public Trainer getTrainer(long trainerId);
	public Trainer getTrainer(String emailId);
	public List<Trainer> getTrainers();
	
	
	//this is for adding education to the trainer
	public long saveTrainersEducationInfo(Trainer trainer, Education education);
	public boolean updateEducationInfo(Education education);
	public Education findEducationInfo(long trainerId);
}
