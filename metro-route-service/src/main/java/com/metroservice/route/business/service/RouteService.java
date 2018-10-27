package com.metroservice.route.business.service;

import com.metroservice.route.business.domain.RouteTO;
import com.metroservice.route.business.util.Util;
import com.metroservice.route.data.entity.Route;
import com.metroservice.route.data.repository.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class RouteService {
	@Autowired
	private DiscoveryClient discoveryClient;
	
	private RouteRepository  routeRepository;

    @Autowired
    public RouteService(RouteRepository routeRepository) {
        this.routeRepository = routeRepository;
    }
	//-------------------------------------------------------------------------------------------
    public List<RouteTO> getAllRoutes(){
		try {
			System.out.println("RouteService.getAllRoutes() ************** entering");
			List<RouteTO> returnRoutes = new ArrayList<>();
			Iterable<Route> routes = this.routeRepository.findAll();
			
			routes.forEach(route->{
				RouteTO routeTO = Util.convertEntityToDTO(route);
				//System.out.println("routeTO = "+routeTO);
				returnRoutes.add(routeTO);
			});
			
//			System.out.println("RouteService.getAllRoutes() ************** discoveryClient="+discoveryClient);
//			List<ServiceInstance> instances=discoveryClient.getInstances("METRO-TRAIN-SERVICE");
//			System.out.println("RouteService.getAllRoutes() ************** instances="+instances);
//			ServiceInstance serviceInstance=instances.get(0);
//			String baseUrl=serviceInstance.getUri().toString(); 
//			System.out.println("RouteService.getAllRoutes() ************** baseUrl="+baseUrl);
			
			return returnRoutes;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
    }
	//-------------------------------------------------------------------------------------------
    public RouteTO getRouteById(long id){
		System.out.println("RouteService.getRouteById() ************** entering");
        Route route = this.routeRepository.findById(id).get();
        RouteTO routeTO = Util.convertEntityToDTO(route);
        //System.out.println("routeTO = "+routeTO);
        
        return routeTO;
    }
	//-------------------------------------------------------------------------------------------
    public RouteTO saveRoute(RouteTO routeTO){
		System.out.println("RouteService.saveRoute() ************** entering");
        Route entity = Util.convertDTOToEntity(routeTO);
        entity.setLastModifiedDate(new Date());
        //System.out.println("RouteService.saveRoute():routeTO = "+routeTO);
		Route entity2 = this.routeRepository.save(entity);
        return Util.convertEntityToDTO(entity2);
    }
	//-------------------------------------------------------------------------------------------
    public void deleteRoute(long id){
		System.out.println("RouteService.deleteRoute() ************** entering");
		this.routeRepository.deleteById(id);
    }
	//-------------------------------------------------------------------------------------------
    public void deleteAllRoutes(){
		System.out.println("RouteService.deleteAllRoutes() ************** entering");
		this.routeRepository.deleteAll();
    }
	//-------------------------------------------------------------------------------------------
	//-------------------------------------------------------------------------------------------
	//-------------------------------------------------------------------------------------------
	//-------------------------------------------------------------------------------------------
	//-------------------------------------------------------------------------------------------
	//-------------------------------------------------------------------------------------------
}
