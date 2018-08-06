package com.metroservice.train.business.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metroservice.train.business.domain.TrainTO;
import com.metroservice.train.business.util.TrainUtil;
import com.metroservice.train.data.entity.Train;
import com.metroservice.train.data.repository.TrainRepository;

@Service
public class TrainService {
	private TrainRepository  trainRepository;

    @Autowired
    public TrainService(TrainRepository trainRepository) {
        this.trainRepository = trainRepository;
    }
    
    
    public List<TrainTO> getAllTrains(){
        List<TrainTO> retTrains = new ArrayList<>();
        Iterable<Train> trains = trainRepository.findAll();
        
        trains.forEach(train->{
			TrainTO trainTO = TrainUtil.convertEntityToDTO(train);
			System.out.println("getAllTrains==================trainTO============ "+trainTO);
			retTrains.add(trainTO);
        });
		
		return retTrains;
    }
    
    public TrainTO getTrainByTrainId(long trainId){
    	System.out.println("getTrainByTrainId service============================== "+trainId);
        Optional<Train> train = trainRepository.findById(trainId);
        TrainTO trainTO = TrainUtil.convertEntityToDTO(train);
        System.out.println("getTrainByTrainId==================trainTO============ "+trainTO);
        
		return trainTO;
    }
    
    public TrainTO getTrainByTrainNumber(long trainNumber){
    	System.out.println("trainNumberin service============================== "+trainNumber);
        Train train = trainRepository.findByTrainNumber(trainNumber);
        System.out.println("getTrainByTrainNumber==================train============ "+train);
        TrainTO trainTO = TrainUtil.convertEntityToDTO(train);
        System.out.println("getTrainByTrainNumber==================trainTO============ "+trainTO);
        
		return trainTO;
    }
    
    public TrainTO addTrain(TrainTO routeTO){
        Train train = TrainUtil.convertDTOToEntity(routeTO);
        Train retTrain = trainRepository.save(train);
        return TrainUtil.convertEntityToDTO(retTrain);
    }
    
    public void deleteAllTrains(){
    	System.out.println("deleteAllTrains============================== ");
        trainRepository.deleteAll();
    }
    
    
    public void deleteTrainByTrainId(long trainId){
    	System.out.println("deleteTrainByTrainId============================== "+trainId);
    	trainRepository.deleteById(trainId);
    }
    
    
    public void deleteTrainByTrainNumber(long trainNumber){
    	System.out.println("deleteTrainByTrainNumber============================== "+trainNumber);
    	trainRepository.deleteTrainByTrainNumber(trainNumber);
    }
    
    public TrainTO updateTrain(TrainTO routeTO){
        Train train = TrainUtil.convertDTOToEntity(routeTO);
        Train retTrain = trainRepository.save(train);
        return TrainUtil.convertEntityToDTO(retTrain);
    }
    
}
