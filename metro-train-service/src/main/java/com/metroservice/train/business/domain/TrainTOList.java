package com.metroservice.train.business.domain;

import java.util.ArrayList;
import java.util.List;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.Data;

//@Getter @Setter 
@Data
public class TrainTOList {
	private List<TrainTO> trainList = new ArrayList<TrainTO>();

//    public List<TrainTO> getTrainList() { 
//		return trainList;
//	}
//	public void setTrainList(List<TrainTO> trainList) { 
//		this.trainList = trainList;
//	}
}
