package com.metroservice.route.business.service;

import com.metroservice.route.business.domain.RouteTO;
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

    public List<RouteTO> getRoutesForDate(String date){
        Iterable<Route> routes = this.routeRepository.findAll();
        
        routes.forEach(route->{
            System.out.println("hihihihihi"+route.getId());
        });
        
        
        
        
        List<RouteTO> routes2 = new ArrayList<>();
        RouteTO oneRoute = new RouteTO();
        oneRoute.setRouteId(71);
        //oneRoute.setRouteName("Shibu");
		routes2.add(oneRoute);

		System.out.println("Shibu3 *****************************************************************");
//		System.out.println("Shibu3 ***routes="+routes);
		
//        for(Long roomId:rRouteMap.keySet()){
//            rRoutes.add(rRouteMap.get(roomId));
//        }
        return routes2;
    }
}
