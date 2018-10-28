package com.metroservice.schedule.consumer.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//@Getter @Setter 
@Entity
@Table(name="ROUTE")
public class RouteTO {
	@Id
    @Column(name="ROUTE_ID")
	private long routeId;
	@Column(name="ROUTE_NUMBER")
	private String routeNumber;
	@Column(name="START_STATION_ID")
	private long startingStationId;
	@Column(name="END_STATION_ID")
	private long endStationId;
	@Column(name="LAST_MODIFIED_DATETIME")
	private Date lastModifiedDate;

	public long getRouteId() {
		return routeId;
	}

	public void setRouteId(long routeId) {
		this.routeId = routeId;
	}

	public String getRouteNumber() {
		return routeNumber;
	}

	public void setRouteNumber(String routeNumber) {
		this.routeNumber = routeNumber;
	}

	public long getStartingStationId() {
		return startingStationId;
	}

	public void setStartingStationId(long startingStationId) {
		this.startingStationId = startingStationId;
	}

	public long getEndStationId() {
		return endStationId;
	}

	public void setEndStationId(long endStationId) {
		this.endStationId = endStationId;
	}

	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("\n");
		sb.append("routeId             =").append(routeId).append("\n");
		sb.append("routeNumber         =").append(routeNumber).append("\n");
		sb.append("startingStationId   =").append(startingStationId)
				.append("\n");
		sb.append("endStationId        =").append(endStationId).append("\n");
		sb.append("lastModifiedDate    =").append(lastModifiedDate)
				.append("\n");
		return sb.toString();
	}
	
	
}
