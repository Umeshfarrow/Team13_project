package com.pratian.project.service;

import java.util.List;

import com.pratian.project.entities.Education;
import com.pratian.project.entities.Trainer;

public interface TrainerService 
{
	public boolean addTrainer(Trainer trainer);
	public boolean updateTrainer(Trainer trainer);
	public Trainer getTrainerByTrainerId(long trainerId);
	public Trainer getTrainerByEmailId(String emailId);
	public List<Trainer> getAllTrainers();
	
	
	
	public boolean addTrainersEducationInfo(Trainer trainer, Education education);
	public boolean editEducationInfo(Education education);
	public Education viewEducationInfo(long trainerId);
}
