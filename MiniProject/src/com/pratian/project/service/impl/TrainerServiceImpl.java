package com.pratian.project.service.impl;

import java.util.List;

import com.pratian.project.dao.TrainerDao;
import com.pratian.project.dao.jpa.JpaTrainerDao;
import com.pratian.project.entities.Education;
import com.pratian.project.entities.Trainer;
import com.pratian.project.service.TrainerService;

public class TrainerServiceImpl implements TrainerService
{
	private TrainerDao trainerDao;
	
	public TrainerServiceImpl()
	{
		this.trainerDao = new JpaTrainerDao();
	}
	
	//adding the education to the trainer
	@Override
	public boolean addTrainersEducationInfo(Trainer trainer, Education education) {
		trainerDao.saveTrainersEducationInfo(trainer, education);
		return false;
	}

	//editing the education to the trainer
	@Override
	public boolean editEducationInfo(Education education) {
		return trainerDao.updateEducationInfo(education);
	}

	//view the education the education of the trainer by using trainerId
	@Override
	public Education viewEducationInfo(long trainerId) {
		Education education = null;
		education = trainerDao.findEducationInfo(trainerId);
		return education;
	}

	//add the trainer
	@Override
	public boolean addTrainer(Trainer trainer) {
		Trainer trainerFromDao=trainerDao.getTrainer(trainer.getTrainerId());
		if(trainerFromDao == null) {
			trainerDao.saveTrainer(trainer);
	}

		return true;
	}

	//update the trainer
	@Override
	public boolean updateTrainer(Trainer trainer) {
		Trainer trainerFromDao = getTrainerByTrainerId(trainer.getTrainerId());
		return trainerDao.updateTrainer(trainer);
	}

	//getting the trainer by using trainerID
	@Override
	public Trainer getTrainerByTrainerId(long trainerId) {
		Trainer trainer = null;
		trainer = trainerDao.getTrainer(trainerId);
		return trainer;
	}

	//getting the trainer by using emailId
	@Override
	public Trainer getTrainerByEmailId(String emailId) {
		Trainer trainer = null;
		trainer = trainerDao.getTrainer(emailId);
		return trainer;
	}

	//getting the list of all trainers in the DB
	@Override
	public List<Trainer> getAllTrainers() {
		List<Trainer> trainers = null;
		trainers = trainerDao.getTrainers();
		return trainers;
	}
	
	public TrainerDao getTrainerDao() {
		return trainerDao;
	}

	public void setTrainerDao(TrainerDao trainerDao) {
		this.trainerDao = trainerDao;
	}
	
	public boolean editTrainer(Trainer trainer) 
	{
		// Check if user id is in DB. If user_id doesn't exist than throw an exception
		Trainer trainerFromDB = getTrainerByTrainerId(trainer.getTrainerId());
		
		return trainerDao.updateTrainer(trainer);
	}

}
