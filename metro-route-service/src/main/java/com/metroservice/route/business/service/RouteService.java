package com.metroservice.route.business.service;

import com.metroservice.route.business.domain.Route;
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

    public List<Route> getRoutesForDate(String date){
//        Iterable<Room> rooms = this.roomRepository.findAll();
//        Map<Long, RoomRoute> roomRouteMap = new HashMap<>();
//        rooms.forEach(room->{
//            RoomRoute roomRoute = new RoomRoute();
//            roomRoute.setRoomId(room.getId());
//            roomRoute.setRoomName(room.getName());
//            roomRoute.setRoomNumber(room.getNumber());
//            roomRouteMap.put(room.getId(), roomRoute);
//        });
//        Iterable<Route> reservations = this.reservationRepository.findByDate(new java.sql.Date(date.getTime()));
//        if(null!=reservations){
//            reservations.forEach(reservation -> {
//                Guest guest = this.guestRepository.findOne(reservation.getGuestId());
//                if(null!=guest){
//                    RoomRoute roomRoute = roomRouteMap.get(reservation.getId());
//                    roomRoute.setDate(date);
//                    roomRoute.setFirstName(guest.getFirstName());
//                    roomRoute.setLastName(guest.getLastName());
//                    roomRoute.setGuestId(guest.getId());
//                }
//            });
//        }
        List<Route> routes = new ArrayList<>();
        Route oneRoute = new Route();
        oneRoute.setRouteId(71);
        oneRoute.setRouteName("Shibu");
		routes.add(oneRoute);

		System.out.println("Shibu3 *****************************************************************");
		System.out.println("Shibu3 ***routes="+routes);
		
//        for(Long roomId:roomRouteMap.keySet()){
//            roomRoutes.add(roomRouteMap.get(roomId));
//        }
        return routes;
    }
}
