package com.metroservice.ui.business.domain;

import java.util.Date;

public class RouteTO {
    private long   routeId             ;
    private String routeNumber         ;
    private long   startingStationId   ;
    private long   endStationId        ;
    private Date   lastModifiedDate    ;

    public long   getRouteId          ()   {        return routeId             ;           } public void setRouteId          (long   routeId             ) {        this.routeId              = routeId             ;    }
    public String getRouteNumber      ()   {        return routeNumber         ;           } public void setRouteNumber      (String routeNumber         ) {        this.routeNumber          = routeNumber         ;    }
    public long   getStartingStationId()   {        return startingStationId   ;           } public void setStartingStationId(long   startingStationId   ) {        this.startingStationId    = startingStationId   ;    }
    public long   getEndStationId     ()   {        return endStationId        ;           } public void setEndStationId     (long   endStationId        ) {        this.endStationId         = endStationId        ;    }
    public Date   getLastModifiedDate ()   {        return lastModifiedDate    ;           } public void setLastModifiedDate (Date   lastModifiedDate    ) {        this.lastModifiedDate     = lastModifiedDate    ;    }
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("\n");
		sb.append("routeId             =").append(routeId             ).append("\n");
		sb.append("routeNumber         =").append(routeNumber         ).append("\n");
		sb.append("startingStationId   =").append(startingStationId   ).append("\n");
		sb.append("endStationId        =").append(endStationId        ).append("\n");
		sb.append("lastModifiedDate    =").append(lastModifiedDate    ).append("\n");
		return sb.toString();
	}
}
