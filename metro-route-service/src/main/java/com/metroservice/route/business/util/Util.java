package com.metroservice.route.business.util;

import com.metroservice.route.business.domain.RouteTO;
import com.metroservice.route.business.domain.StationTO;
import com.metroservice.route.data.entity.Route;
import com.metroservice.route.data.entity.Station;
import java.util.Date;

public class Util {
	//------------------------------------------------------------------------------------
	public static RouteTO convertEntityToDTO(Route entity) {
		RouteTO to = new RouteTO();
		to.setRouteId          (entity.getId               ());
		to.setStartingStationId(entity.getStartingStationId());
		to.setEndStationId     (entity.getEndStationId     ());
		to.setLastModifiedDate (entity.getLastModifiedDate ());
		return to;
	}
	
	public static Route convertDTOToEntity(RouteTO to) {
		Route entity = new Route();
		entity.setId               (to.getRouteId          ());
		entity.setStartingStationId(to.getStartingStationId());
		entity.setEndStationId     (to.getEndStationId     ());
		entity.setLastModifiedDate (to.getLastModifiedDate ());
		return entity;
	}
	//------------------------------------------------------------------------------------
	public static StationTO convertEntityToDTO(Station entity) {
		StationTO to = new StationTO();
		to.setStationId          (entity.getId               ());
		to.setStationName        (entity.getStationName      ());
		to.setLastModifiedDate   (entity.getLastModifiedDate ());
		return to;
	}
	
	public static Station convertDTOToEntity(StationTO to) {
		Station entity = new Station();
		entity.setId               (to.getStationId          ());
		entity.setStationName      (to.getStationName        ());
		entity.setLastModifiedDate (to.getLastModifiedDate   ());
		return entity;
	}
	//------------------------------------------------------------------------------------
	//------------------------------------------------------------------------------------
	//------------------------------------------------------------------------------------
}


