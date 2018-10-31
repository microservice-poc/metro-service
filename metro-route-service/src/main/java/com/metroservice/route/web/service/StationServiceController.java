package com.metroservice.route.web.service;

import com.metroservice.route.business.domain.StationTO;
import com.metroservice.route.business.domain.StationListTO;
import com.metroservice.route.business.service.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StationServiceController {

    @Autowired
    private StationService stationService;
    //------------------------------------------------------------------------------------------------------------------------------
    @RequestMapping(method= RequestMethod.GET, value="/station/all")
    public StationListTO getAllStations() throws Exception {
		List<StationTO> stations = this.stationService.getAllStations();
		System.out.println("StationServiceController.getAllStations() ***stations="+stations);
		StationListTO stoList = new StationListTO();
		stoList.setStationList(stations);
        return stoList;
    }
    //------------------------------------------------------------------------------------------------------------------------------
    @RequestMapping(method= RequestMethod.GET, value="/station/{id}")
    public StationTO getStationById(@PathVariable(value="id")String id) throws Exception {
		StationTO station = this.stationService.getStationById(Long.valueOf(id));
		System.out.println("StationServiceController.getStationById() ***station="+station);
        return station;
    }
    //------------------------------------------------------------------------------------------------------------------------------
    @RequestMapping(method= RequestMethod.POST, value="/station/save")
    public void saveStation(@RequestBody StationTO stationTO) throws Exception {
		System.out.println("StationServiceController.saveStation():***stationTO="+stationTO);
		StationTO dto = this.stationService.saveStation(stationTO);
		System.out.println("StationServiceController.saveStation():***dto="+dto);
    }
    //------------------------------------------------------------------------------------------------------------------------------
    @RequestMapping(method= RequestMethod.DELETE, value="/station/{id}")
    public void deleteStation(@PathVariable(value="id")String id) throws Exception {
		System.out.println("StationServiceController.deleteStation():***id="+id);
		this.stationService.deleteStation(Long.valueOf(id));
		System.out.println("StationServiceController.deleteStation():***dto=");
    }
    //------------------------------------------------------------------------------------------------------------------------------
    @RequestMapping(method= RequestMethod.DELETE, value="/station/deleteAll")
    public void deleteAllStations() throws Exception {
		System.out.println("StationServiceController.deleteAllStations().enter");
		this.stationService.deleteAllStations();
		System.out.println("StationServiceController.deleteAllStations().exit");
    }
    //------------------------------------------------------------------------------------------------------------------------------
//    @RequestMapping(value = "/train/trainId/{trainId}", method = RequestMethod.DELETE)
//    public void deleteTrainByTrainId(@PathVariable(value="trainId")String trainId) throws Exception {
//		trainService.deleteTrainByTrainId(Long.valueOf(trainId));
//	}
    //------------------------------------------------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------------------------
}
