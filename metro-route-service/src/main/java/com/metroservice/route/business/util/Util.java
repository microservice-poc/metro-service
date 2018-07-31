package com.metroservice.route.business.util;

import com.metroservice.route.business.domain.RouteTO;
import com.metroservice.route.data.entity.Route;
import java.util.Date;

public class Util {
	public static RouteTO convertEntityToDTO(Route entity) {
		RouteTO to = new RouteTO();
		to.setRouteId          (entity.getId               ());
		to.setStartingStationId(entity.getStartingStationId());
		to.setEndStationId     (entity.getEndStationId     ());
		to.setLastModifiedDate (entity.getLastModifiedDate ());
		return to;
	}
	
    private long   routeId             ;
    private long   startingStationId   ;
    private long   endStationId        ;
    private Date   lastModifiedDate    ;

    public long   getRouteId          ()   {        return routeId             ;           } public void setRouteId          (long   routeId             ) {        this.routeId              = routeId             ;    }
    public long   getStartingStationId()   {        return startingStationId   ;           } public void setStartingStationId(long   startingStationId   ) {        this.startingStationId    = startingStationId   ;    }
    public long   getEndStationId     ()   {        return endStationId        ;           } public void setEndStationId     (long   endStationId        ) {        this.endStationId         = endStationId        ;    }
    public Date   getLastModifiedDate ()   {        return lastModifiedDate    ;           } public void setLastModifiedDate (Date   lastModifiedDate    ) {        this.lastModifiedDate     = lastModifiedDate    ;    }
}


