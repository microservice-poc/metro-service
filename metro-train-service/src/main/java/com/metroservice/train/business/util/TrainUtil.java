package com.metroservice.train.business.util;



import com.metroservice.train.business.domain.TrainTO;
import com.metroservice.train.data.entity.Train;

public class TrainUtil {
	public static TrainTO convertEntityToDTO(Train trainEntity) {
		TrainTO retTrainTO = new TrainTO();
		retTrainTO.setTrainId(trainEntity.getId());
		retTrainTO.setTrainName(trainEntity.getTrainName());
		retTrainTO.setTrainNumber(trainEntity.getTrainNumber());
		retTrainTO.setLastServicedDate(trainEntity.getLastServicedDate());
		retTrainTO.setLastModifiedDate(trainEntity.getLastModifiedDate ());
		return retTrainTO;
	}
	
   
}


