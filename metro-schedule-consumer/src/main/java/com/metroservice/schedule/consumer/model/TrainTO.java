package com.metroservice.schedule.consumer.model;

import java.util.Date;

public class TrainTO {
	
	private long   trainId             ;
    private String trainName           ;
    private long   trainNumber         ;
    private Date   lastServicedDate    ;
    private Date   lastModifiedDate    ;
    
	public long getTrainId() {
		return trainId;
	}
	public void setTrainId(long trainId) {
		this.trainId = trainId;
	}
	public String getTrainName() {
		return trainName;
	}
	public void setTrainName(String trainName) {
		this.trainName = trainName;
	}
	public long getTrainNumber() {
		return trainNumber;
	}
	public void setTrainNumber(long trainNumber) {
		this.trainNumber = trainNumber;
	}
	public Date getLastServicedDate() {
		return lastServicedDate;
	}
	public void setLastServicedDate(Date lastServicedDate) {
		this.lastServicedDate = lastServicedDate;
	}
	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}
	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}
    
}
