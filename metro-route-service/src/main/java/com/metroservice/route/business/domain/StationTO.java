package com.metroservice.route.business.domain;

import java.util.Date;

public class StationTO {
    private long   stationId           ;
    private String stationName         ;
    private Date   lastModifiedDate    ;

    public long   getStationId        ()   {        return stationId           ;           } public void setStationId        (long   stationId           ) {        this.stationId            = stationId           ;    }
    public String getStationName      ()   {        return stationName         ;           } public void setStationName      (String stationName         ) {        this.stationName          = stationName         ;    }
    public Date   getLastModifiedDate ()   {        return lastModifiedDate    ;           } public void setLastModifiedDate (Date   lastModifiedDate    ) {        this.lastModifiedDate     = lastModifiedDate    ;    }
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("\n");
		sb.append("stationId          =").append(stationId           ).append("\n");
		sb.append("stationName        =").append(stationName         ).append("\n");
		sb.append("lastModifiedDate   =").append(lastModifiedDate    ).append("\n");
		return sb.toString();
	}
}
