package com.metroservice.route.business.service;

import com.metroservice.route.business.domain.StationTO;
import com.metroservice.route.business.util.Util;
import com.metroservice.route.data.entity.Station;
import com.metroservice.route.data.repository.StationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class StationService {
    private StationRepository  stationRepository;

    @Autowired
    public StationService(StationRepository stationRepository) {
        this.stationRepository = stationRepository;
    }
	//-------------------------------------------------------------------------------------------
    public List<StationTO> getAllStations(){
		System.out.println("StationService.getAllStations() ************** entering");
        List<StationTO> returnStations = new ArrayList<>();
        Iterable<Station> stations = this.stationRepository.findAll();
        
        stations.forEach(station->{
			StationTO stationTO = Util.convertEntityToDTO(station);
			//System.out.println("stationTO = "+stationTO);
			returnStations.add(stationTO);
        });
        
        return returnStations;
    }
	//-------------------------------------------------------------------------------------------
    public StationTO getStationById(long id){
		System.out.println("StationService.getStationById() ************** entering");
        Station station = this.stationRepository.findById(id).get();
        StationTO stationTO = Util.convertEntityToDTO(station);
        //System.out.println("stationTO = "+stationTO);
        
        return stationTO;
    }
	//-------------------------------------------------------------------------------------------
    public StationTO saveStation(StationTO stationTO){
		System.out.println("StationService.saveStation() ************** entering");
        Station entity = Util.convertDTOToEntity(stationTO);
        entity.setLastModifiedDate(new Date());
        //System.out.println("StationService.saveStation():stationTO = "+stationTO);
		Station entity2 = this.stationRepository.save(entity);
        return Util.convertEntityToDTO(entity2);
    }
	//-------------------------------------------------------------------------------------------
    public void deleteStation(long id){
		System.out.println("StationService.deleteStation() ************** entering");
		this.stationRepository.deleteById(id);
    }
	//-------------------------------------------------------------------------------------------
    public void deleteAllStations(){
		System.out.println("StationService.deleteAllStations() ************** entering");
		this.stationRepository.deleteAll();
    }
	//-------------------------------------------------------------------------------------------
	//-------------------------------------------------------------------------------------------
	//-------------------------------------------------------------------------------------------
	//-------------------------------------------------------------------------------------------
	//-------------------------------------------------------------------------------------------
	//-------------------------------------------------------------------------------------------
}
