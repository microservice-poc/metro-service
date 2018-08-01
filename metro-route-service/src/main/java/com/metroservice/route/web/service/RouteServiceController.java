package com.metroservice.route.web.service;

import com.metroservice.route.business.domain.RouteTO;
import com.metroservice.route.business.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.ArrayList;

@RestController
public class RouteServiceController {

    @Autowired
    private RouteService routeService;
    //------------------------------------------------------------------------------------------------------------------------------
    @RequestMapping(method= RequestMethod.GET, value="/route/all")
    public List<RouteTO> getAllRoutes() throws Exception {
		List<RouteTO> routes = this.routeService.getAllRoutes();
		System.out.println("getAllRoutes ***routes="+routes);
        return routes;
    }
    //------------------------------------------------------------------------------------------------------------------------------
    @RequestMapping(method= RequestMethod.GET, value="/route/{id}")
    public RouteTO getRouteById(@PathVariable(value="id")String id) throws Exception {
		RouteTO route = this.routeService.getRouteById(Long.valueOf(id));
		System.out.println("getRouteById ***route="+route);
        return route;
    }
    //------------------------------------------------------------------------------------------------------------------------------
    @RequestMapping(method= RequestMethod.POST, value="/route/save")
    public void saveRoute(@RequestBody RouteTO routeTO) throws Exception {
		System.out.println("RouteServiceController.saveRoute():***routeTO="+routeTO);
		RouteTO dto = this.routeService.saveRoute(routeTO);
		System.out.println("RouteServiceController.saveRoute():***dto="+dto);
    }
    //------------------------------------------------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------------------------
}
