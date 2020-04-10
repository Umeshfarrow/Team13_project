package com.pratian.project.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.pratian.project.dao.TrainerDao;
import com.pratian.project.dao.util.JpaUtil;
import com.pratian.project.entities.Education;
import com.pratian.project.entities.Trainer;

public class JpaTrainerDao implements TrainerDao 
{
	//saving the trainer to the DB
	@Override
	public long saveTrainer(Trainer trainer) {
		// TODO Auto-generated method stub

		// Get Entity Manager
		EntityManager em = JpaUtil.getEntityManager();

		// Begin Transaction
		EntityTransaction et = em.getTransaction();
		et.begin();

		// Save / Persist trainer
		em.persist(trainer);

		// Commit Transaction
		et.commit();

		// Close the Manager
		em.close();

		//returning the trainerId
		return trainer.getTrainerId();
	}

	//Updating the trainer to the DB
	@Override
	public boolean updateTrainer(Trainer trainer)
	{
		// Get Entity Manager
		EntityManager em = JpaUtil.getEntityManager();

		// Begin Transaction
		EntityTransaction et = em.getTransaction();
		et.begin();

		// setting the updated data to the Trainer
		Trainer existingTrainer = em.find(Trainer.class, trainer.getTrainerId());
		existingTrainer.setFullName(trainer.getFullName());
		existingTrainer.setEmailId(trainer.getEmailId());
		existingTrainer.setYearlyTarget(trainer.getYearlyTarget());
		existingTrainer.setAge(trainer.getAge());

		// Commit Transaction
		et.commit();

		// Close the Manager
		em.close();
		return false;

	}

	//getting the trainer details by using trainerId
	@Override
	public Trainer getTrainer(long trainerId) {
		Trainer trainer = null;

		// Get Entity Manager
		EntityManager em = JpaUtil.getEntityManager();

		// Begin Transaction
		EntityTransaction et = em.getTransaction();
		et.begin();

		// Get Trainer by trainerId
		trainer = em.find(Trainer.class, trainerId);

		// commit transaction
		et.commit();

		// Close the manager
		em.close();
		
		//returning the trainer details
		return trainer;
	}

	//getting the trainer details by using trainer emailId
	@Override
	public Trainer getTrainer(String emailId) 
	{
		Trainer trainer = null;

		// Get Entity Manager
		EntityManager em = JpaUtil.getEntityManager();

		//Query for getting the details of trainer by using emaillId
		String jpql = "from Trainer where emailId =:emailId";
		
		//Execute the Query
		Query query = em.createQuery(jpql, Trainer.class);
		query.setParameter("emailId", emailId);
		
		//it will get the result of the query
		List<Trainer> trainers = query.getResultList();

		// Close the Manager
		em.close();
		return trainers.get(0);
	}

	//getting the list of trainers
	@Override
	public List<Trainer> getTrainers() {
		Trainer trainer = null;
		// Get Entity Manager
		EntityManager em = JpaUtil.getEntityManager();

		// Get Entity Transaction
		EntityTransaction et = em.getTransaction();
		et.begin();

		// Write jpql
		String jpql = "from Trainer";

		Query query = em.createQuery(jpql, Trainer.class);

		List<Trainer> trainers = query.getResultList();

		// Close Entity Manager
		et.commit();

		// Close the Manager
		em.close();
		return trainers;
	}
	
	

	// adding a Education to the DB
	@Override
	public long saveTrainersEducationInfo(Trainer trainer, Education education) {
		Trainer trainer1 = null;

		// Get Entity Manager
		EntityManager em = JpaUtil.getEntityManager();

		// Begin Transaction
		EntityTransaction et = em.getTransaction();
		et.begin();

		// Save / Persist Education
		em.persist(education);

		// to find the details trainer details by using trainer id
		trainer1 = em.find(Trainer.class, trainer.getTrainerId());

		// to find the details education details by using education id
		Education education1 = em.find(Education.class, education.getEducationId());

		// setting the education to the trainer1
		trainer1.setEducation(education1);

		et.commit();
		em.close();

		// returning the educationId
		return education.getEducationId();
	}

	// updating the educationInfo
	@Override
	public boolean updateEducationInfo(Education education) {
		// Get Entity Manager
		EntityManager em = JpaUtil.getEntityManager();

		// Begin Transaction
		EntityTransaction et = em.getTransaction();
		et.begin();

		// Save / Persist Education
		Education existingEducation = em.find(Education.class, education.getEducationId());

		// setting the updated data to the education
		existingEducation.setInstituteName(education.getInstituteName());
		existingEducation.setDegree(education.getDegree());
		existingEducation.setSpecialization(education.getSpecialization());
		existingEducation.setStartYear(education.getStartYear());
		existingEducation.setEndYear(education.getEndYear());
		existingEducation.setCourseDuration(education.getCourseDuration());
		existingEducation.setBoard(education.getBoard());
		existingEducation.setPercentage(education.getPercentage());
		existingEducation.setCity(education.getCity());
		existingEducation.setState(education.getState());
		existingEducation.setCountry(education.getCountry());

		// Commit Transaction
		et.commit();

		// Close the Manager
		em.close();
		return true;
	}

	// finding the education info by using trainer Id
	@Override
	public Education findEducationInfo(long trainerId) {
		Education education = null;
		// Get Entity Manager
		EntityManager em = JpaUtil.getEntityManager();

		// Executing the query
		Query query = em.createQuery("select e from Trainer t inner join Education e "
				+ " on e.educationId = t.education.educationId where t.trainerId =:trainersId");

		// setting the query
		query.setParameter("trainersId", trainerId);

		//it will get the result of the query
		List<Education> educations = query.getResultList();

		// If list is empty, then assign null
		education = ((educations.size() == 0) ? null : educations.get(0));

		// Close the Manager
		em.close();

		return education;
	}

	

}
