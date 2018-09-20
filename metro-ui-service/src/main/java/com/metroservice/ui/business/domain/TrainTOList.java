package com.metroservice.ui.business.domain;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;

//@Getter @Setter 
@Data
public class TrainTOList {
	private List<TrainTO> trainList = new ArrayList<TrainTO>();
}
