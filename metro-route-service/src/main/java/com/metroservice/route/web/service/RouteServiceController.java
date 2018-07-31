package com.metroservice.route.web.service;

import com.metroservice.route.business.domain.RouteTO;
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
    public List<RouteTO> getAllRoutesForDate(@PathVariable(value="date")String dateString) throws Exception {
		System.out.println("Shibu2 *****************************************************************="+routeService);
		List<RouteTO> routes = this.routeService.getRoutesForDate(dateString);
		System.out.println("Shibu2 ***routes="+routes);
        return routes;
    }
}
