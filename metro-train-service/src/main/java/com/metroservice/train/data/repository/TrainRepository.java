package com.metroservice.train.data.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.metroservice.train.data.entity.Train;

@Repository
public interface TrainRepository extends CrudRepository<Train, Long> {
	
	@Query("SELECT t FROM Train t where t.trainNumber = ?1")
	public Train findByTrainNumber(long trainNumber);
	
	
	@Query("DELETE FROM Train t where t.trainNumber = ?1")
	public Train deleteTrainByTrainNumber(long trainNumber);

}