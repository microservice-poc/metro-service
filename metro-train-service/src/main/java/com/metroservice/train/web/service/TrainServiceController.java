package com.metroservice.train.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.metroservice.train.business.domain.TrainTO;
import com.metroservice.train.business.service.TrainService;

@RestController
public class TrainServiceController {

    @Autowired
    private TrainService trainService;

    @RequestMapping(method= RequestMethod.GET, value="/trains")
    public List<TrainTO> getAllTrains() throws Exception {
		System.out.println("getAllTrains**********************trainService*******************************************="+trainService);
		List<TrainTO> trainsListTo = trainService.getAllTrains();
		System.out.println("All trains======================================"+trainsListTo);
        return trainsListTo;
    }
    
    @RequestMapping(method= RequestMethod.GET, value="/train/trainId/{trainId}")
    public TrainTO getTrainByTrainId(@PathVariable(value="trainId")String trainId) throws Exception {
		System.out.println("getTrainByTrainId**********************trainService*******************************************="+trainService);
		System.out.println("getTrainByTrainId**********************trainId*******************************************="+trainId);
		
		TrainTO trainTO = trainService.getTrainByTrainId(Long.valueOf(trainId));
		System.out.println("getTrainByTrainNumber in Controller======================================"+trainTO);
        return trainTO;
    }
    
    @RequestMapping(method= RequestMethod.GET, value="/train/{trainNumber}")
    public TrainTO getTrainByTrainNumber(@PathVariable(value="trainNumber")String trainNumber) throws Exception {
		System.out.println("getTrainByTrainNumber**********************Controller*******************************************="+trainService);
		System.out.println("getTrainByTrainNumber**********************Controller*******************************************="+trainNumber);
		
		TrainTO trainTO = trainService.getTrainByTrainNumber(Long.valueOf(trainNumber));
		System.out.println("getTrainByTrainNumber in Controller======================================"+trainTO);
        return trainTO;
    }
    
    @RequestMapping(method= RequestMethod.POST, value="/train/add")
    public void addTrain(@RequestBody TrainTO trainTO) throws Exception {
		System.out.println("TrainServiceController.saveTrain():***trainTO="+trainTO);
		TrainTO retTrainTo = trainService.addTrain(trainTO);
		System.out.println("TrainServiceController.saveRoute():***retTrainTo="+retTrainTo);
    }
    
    
    @RequestMapping(value = "/train/deleteAll", method = RequestMethod.DELETE)
    public void deleteAllTrains() throws Exception {
		trainService.deleteAllTrains();
	}
    
    
    @RequestMapping(value = "/train/trainId/{trainId}", method = RequestMethod.DELETE)
    public void deleteTrainByTrainId(@PathVariable(value="trainId")String trainId) throws Exception {
		trainService.deleteTrainByTrainId(Long.valueOf(trainId));
	}
    
    
    @RequestMapping(value = "/train/{trainNumber}", method = RequestMethod.DELETE)
    public void deleteTrainByTrainNumber(@PathVariable(value="trainNumber")String trainNumber) throws Exception {
		trainService.deleteTrainByTrainNumber(Long.valueOf(trainNumber));
	}
    
    
    @RequestMapping(method= RequestMethod.PUT, value="/train/update")
    public void updateTrain(@RequestBody TrainTO trainTO) throws Exception {
		System.out.println("TrainServiceController.updateTrain():***trainTO="+trainTO);
		TrainTO retTrainTo = trainService.updateTrain(trainTO);
		System.out.println("TrainServiceController.updateTrain():***retTrainTo="+retTrainTo);
    }
    
}