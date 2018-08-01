package com.metroservice.route.business.service;

import com.metroservice.route.business.domain.RouteTO;
import com.metroservice.route.business.util.Util;
import com.metroservice.route.data.entity.Route;
import com.metroservice.route.data.repository.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RouteService {
    private RouteRepository  routeRepository;

    @Autowired
    public RouteService(RouteRepository routeRepository) {
        this.routeRepository = routeRepository;
    }
	//-------------------------------------------------------------------------------------------
    public List<RouteTO> getAllRoutes(){
        List<RouteTO> returnRoutes = new ArrayList<>();
        Iterable<Route> routes = this.routeRepository.findAll();
        
        routes.forEach(route->{
			RouteTO routeTO = Util.convertEntityToDTO(route);
			System.out.println("routeTO = "+routeTO);
			returnRoutes.add(routeTO);
        });
		
		//Route route = new Route();
		//route.setId(9999);
		//route.setStartingStationId(997);
		//route.setEndStationId(998);
		//route.setLastModifiedDate(new Date());
		//this.routeRepository.save(route);
        
        return returnRoutes;
    }
	//-------------------------------------------------------------------------------------------
    public RouteTO getRouteById(long id){
        Route route = this.routeRepository.findOne(id);
        RouteTO routeTO = Util.convertEntityToDTO(route);
        System.out.println("routeTO = "+routeTO);
        
        return routeTO;
    }
	//-------------------------------------------------------------------------------------------
    public RouteTO saveRoute(RouteTO routeTO){
        Route entity = Util.convertDTOToEntity(routeTO);
        System.out.println("RouteService.saveRoute():routeTO = "+routeTO);
		Route entity2 = this.routeRepository.save(entity);
        return Util.convertEntityToDTO(entity2);
    }
	//-------------------------------------------------------------------------------------------
	//-------------------------------------------------------------------------------------------
	//-------------------------------------------------------------------------------------------
	//-------------------------------------------------------------------------------------------
	//-------------------------------------------------------------------------------------------
	//-------------------------------------------------------------------------------------------
}
