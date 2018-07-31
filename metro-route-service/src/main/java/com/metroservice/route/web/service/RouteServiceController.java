package com.metroservice.route.web.service;

import com.metroservice.route.business.domain.Route;
import com.metroservice.route.business.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.ArrayList;

@RestController
public class RouteServiceController {

    @Autowired
    private RouteService routeService;

    @RequestMapping(method= RequestMethod.GET, value="/route/{date}")
    public List<Route> getAllRoutesForDate(@PathVariable(value="date")String dateString) throws Exception {
		System.out.println("Shibu2 *****************************************************************="+routeService);
		List<Route> routes = this.routeService.getRoutesForDate(dateString);
		System.out.println("Shibu2 ***routes="+routes);
        //List<Route> routes2 = new ArrayList<>();
        //Route oneRoute = new Route();
        //oneRoute.setRouteId(1);
        //oneRoute.setRouteName("Shibu");
		//routes2.add(oneRoute);
		//System.out.println("Shibu2 ***routes2="+routes2);
		//Thread.sleep(300000);
        return routes;
    }
}
